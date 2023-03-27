//
// Created by Арслан Гиниятуллин on 12/11/22.
//

#include "malloc_tests.h"
#include "mem.h"
#include "mem_internals.h"

#define HEAP_SIZE 10000
#define BLOCK_SIZE 10

static inline void print_message(FILE * src, char *tmp, char *msg) {
    fprintf(src, tmp, msg);
}
static void print_error() {
   print_message(stderr, ">>%s\n", "FAILED");
}

static void print_success() {
    print_message(stdout, ">>%s\n", "SUCCESS");
}
bool test_allocation() {
    print_message(stdout, ">>%s\n", "Test 1: Memory allocation");
    void *heap = heap_init(HEAP_SIZE), *temp = _malloc(BLOCK_SIZE);
    debug_heap(stdout, heap);
    if (!temp) {
        print_error();
        return false;
    }
    _free(temp);
    munmap(heap, size_from_capacity((block_capacity) {.bytes=HEAP_SIZE}).bytes);
    print_success();
    return true;
}

bool test_block_free() {
    print_message(stdout, ">>%s\n", "Test 2: Free block");
    void *heap = heap_init(HEAP_SIZE), *_1 = _malloc(BLOCK_SIZE), *_2 = _malloc(BLOCK_SIZE);
    debug_heap(stdout, heap);
    _free(_1);
    debug_heap(stdout, heap);
    _free(_2);
    munmap(heap, size_from_capacity((block_capacity) {.bytes=HEAP_SIZE}).bytes);
    print_success();
    return true;
}

bool test_multiple_block_free() {
    print_message(stdout, ">>%s\n", "Test 3: Free multiple blocks");
    void *heap = heap_init(HEAP_SIZE), *_1 = _malloc(BLOCK_SIZE), *_2 = _malloc(BLOCK_SIZE), *_3 = _malloc(BLOCK_SIZE);
    debug_heap(stdout, heap);
    _free(_1);
    _free(_2);
    debug_heap(stdout, heap);
    _free(_3);
    munmap(heap, size_from_capacity((block_capacity) {.bytes=HEAP_SIZE}).bytes);
    print_success();
    return true;
}

bool test_region_extends() {
    print_message(stdout, ">>%s\n", "Test 4: Memory region extends");
    void *heap = heap_init(HEAP_SIZE), *_1 = _malloc(HEAP_SIZE), *_2 = _malloc(HEAP_SIZE);
    debug_heap(stdout, heap);
    _free(_1);
    _free(_2);
    debug_heap(stdout, heap);
    munmap(HEAP_START, 4 * size_from_capacity((block_capacity) { HEAP_SIZE }).bytes);
    print_success();
    return true;
}

bool test_region_does_not_extend() {
    print_message(stdout, ">>%s\n", "Test 5: Memory region does not extend");
    void* heap = heap_init(HEAP_SIZE);
    void *temp_mmap = mmap((uint64_t*)(heap) + REGION_MIN_SIZE, HEAP_SIZE, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS | MAP_FIXED , -1, 0);

    debug_heap(stdout, heap);

    if (temp_mmap == MAP_FAILED) {
        print_error();
        return false;
    }

    struct block_header* res = _malloc(REGION_MIN_SIZE + 5);

    debug_heap(stdout, heap);

    if (res->capacity.bytes != REGION_MIN_SIZE + 5) {
        print_error(), _free(res);
        return false;
    }

    _free(res);
    munmap(heap, REGION_MIN_SIZE + HEAP_SIZE);
    print_success();
    return true;
}
