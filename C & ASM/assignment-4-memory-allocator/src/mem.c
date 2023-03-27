
#define _DEFAULT_SOURCE

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "mem_internals.h"
#include "mem.h"
#include "util.h"

void debug_block(struct block_header* b, const char* fmt, ... );
void debug(const char* fmt, ... );

extern inline block_size size_from_capacity( block_capacity cap );
extern inline block_capacity capacity_from_size( block_size sz );

static bool            block_is_big_enough( size_t query, struct block_header* block ) { return block->capacity.bytes >= query; }
static size_t          pages_count   ( size_t mem )                      { return mem / getpagesize() + ((mem % getpagesize()) > 0); }
static size_t          round_pages   ( size_t mem )                      { return getpagesize() * pages_count( mem ) ; }

static void block_init( void* restrict addr, block_size block_sz, void* restrict next ) {
  *((struct block_header*)addr) = (struct block_header) {
    .next = next,
    .capacity = capacity_from_size(block_sz),
    .is_free = true
  };
}

static size_t region_actual_size( size_t query ) { return size_max( round_pages( query ), REGION_MIN_SIZE ); }

extern inline bool region_is_invalid( const struct region* r );



static void* map_pages(void const* addr, size_t length, int additional_flags) {
  return mmap( (void*) addr, length, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS | additional_flags , -1, 0 );
}

/*  аллоцировать регион памяти и инициализировать его блоком */
static struct region alloc_region(void const *addr, size_t query) { //query - block_capacity
    size_t actual_size = region_actual_size(size_from_capacity((block_capacity) {.bytes = query}).bytes);

    void *region_addr = map_pages(addr, actual_size, MAP_FIXED_NOREPLACE); // kernel allocates mem at an addr

    if (region_addr ==
        MAP_FAILED) { //mmap can create an address 0x0, but can't return undistinguished pointer (void*)-1
        region_addr = map_pages(addr, actual_size, 0);
        if (region_addr == MAP_FAILED) return REGION_INVALID;
    }

    block_init(region_addr, (block_size) {.bytes = actual_size},
               NULL); //if map_paged performed successfully initiate first block
    return (struct region) {.addr = region_addr, .size = actual_size, .extends = region_addr == addr};
}

static void* block_after( struct block_header const* block )         ;

void* heap_init( size_t initial ) {
  const struct region region = alloc_region( HEAP_START, initial );
  if ( region_is_invalid(&region) ) return NULL;

  return region.addr;
}

#define BLOCK_MIN_CAPACITY 24

/*  --- Разделение блоков (если найденный свободный блок слишком большой )--- */

static bool block_splittable(struct block_header *restrict block, size_t query) {
    return block->is_free &&
           query + offsetof(struct block_header, contents) + BLOCK_MIN_CAPACITY <= block->capacity.bytes;
}

static bool split_if_too_big(struct block_header *block, size_t query) {
    if (!block_splittable(block, query)) return false;
    void *next_block = block->contents + query; //step forward for query to get second block addr
    block_size next_block_size = {.bytes = block->capacity.bytes - query};

    block_init(next_block, next_block_size, block->next);

    block->capacity.bytes = query;
    block->next = next_block;

    return true;
}


/*  --- Слияние соседних свободных блоков --- */

static void* block_after( struct block_header const* block )              {
  return  (void*) (block->contents + block->capacity.bytes);
}
static bool blocks_continuous (
                               struct block_header const* fst,
                               struct block_header const* snd ) {
  return (void*)snd == block_after(fst);
}

static bool mergeable(struct block_header const* restrict fst, struct block_header const* restrict snd) {
  return fst->is_free && snd->is_free && blocks_continuous( fst, snd ) ;
}

static bool try_merge_with_next(struct block_header *block) {
    if (!block) return false;
    struct block_header *next_block = block->next;
    if (!next_block || !mergeable(block, next_block)) return false;
    block->capacity.bytes += size_from_capacity(next_block->capacity).bytes;
    block->next = next_block->next;
    return true;
}


/*  --- ... ecли размера кучи хватает --- */

struct block_search_result {
  enum {BSR_FOUND_GOOD_BLOCK, BSR_REACHED_END_NOT_FOUND, BSR_CORRUPTED} type;
  struct block_header* block;
};

static inline bool is_good_block(struct block_header *restrict block, size_t size) {
    return block->is_free && block_is_big_enough(size, block);
}

static inline bool is_corrupted_block(struct block_header *restrict block) {
    return block && block->next == block;
}

static struct block_search_result find_good_or_last(struct block_header *restrict block, size_t sz) {
    if (!block) return (struct block_search_result) {.type = BSR_CORRUPTED};
    while (1) {
        while (try_merge_with_next(block));
        if (is_good_block(block, sz)) {
            return (struct block_search_result) {
                    .type = BSR_FOUND_GOOD_BLOCK,
                    .block = block,
            };
        }
        if (is_corrupted_block(block)) {
            return (struct block_search_result) {
                    .type = BSR_CORRUPTED,
            };
        }
        if (!block->next) break;
        block = block->next;
    }
    return (struct block_search_result) {.type = BSR_REACHED_END_NOT_FOUND, .block = block};
}

/*  Попробовать выделить память в куче начиная с блока `block` не пытаясь расширить кучу
 Можно переиспользовать как только кучу расширили. */
static struct block_search_result try_memalloc_existing(size_t query, struct block_header *block) {
    struct block_search_result search_result = find_good_or_last(block, query);
    if (search_result.type == BSR_FOUND_GOOD_BLOCK) {
        split_if_too_big(search_result.block, query), search_result.block->is_free = false;
    }
    return search_result;
}


static struct block_header *grow_heap(struct block_header *restrict last, size_t query) {
    if (!last) return NULL;
    uint8_t *close_address = last->contents + last->capacity.bytes;
    struct region region = alloc_region(close_address, query);
    if (!region_is_invalid(&region) && region.extends && last->is_free) { //if it turned out to allocate memory, we do it closely to prev region
        last->capacity.bytes += region.size;
        return last;
    }
    last->next = region.addr; //else we do the link to from last block to the new region.addr
    return region.addr;
}

/*  Реализует основную логику malloc и возвращает заголовок выделенного блока */
static struct block_header *memalloc(size_t query, struct block_header *heap_start) {
    query = size_max(BLOCK_MIN_CAPACITY, query);
    struct block_search_result alloc_result;
    while ((alloc_result = try_memalloc_existing(query, heap_start)).type == BSR_REACHED_END_NOT_FOUND) {
        if (!grow_heap(alloc_result.block, query)) {
            return NULL; //trying to allocate in current region, if it's impossible, growing heap with another regions
        }
    }
    return alloc_result.type == BSR_FOUND_GOOD_BLOCK ? alloc_result.block : NULL;
}

void *_malloc(size_t query) {
    struct block_header *const addr = memalloc(query, (struct block_header *) HEAP_START);
    if (addr) {
        return addr->contents;
    } else {
        return NULL;
    }
}

static struct block_header* block_get_header(void* contents) {
  return (struct block_header*) (((uint8_t*)contents)-offsetof(struct block_header, contents));
}

void _free(void *mem) {
    if (!mem) return;
    struct block_header *header = block_get_header(mem);
    header->is_free = true;
    while (try_merge_with_next(header));//trying to merge next blocks with current, increasing capacity of current header
}
