//
// Created by Арслан Гиниятуллин on 12/11/22.
//

#ifndef MEMORY_ALLOCATOR_MALLOC_TESTS_H
#define MEMORY_ALLOCATOR_MALLOC_TESTS_H
#define TEST_PASS_SUCCESS 0
#define TEST_PASS_FAILED 1
#include <stdbool.h>
bool test_allocation();
bool test_block_free();
bool test_multiple_block_free();
bool test_region_extends();
bool test_region_does_not_extend();

#endif //MEMORY_ALLOCATOR_MALLOC_TESTS_H
