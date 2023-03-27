//
// Created by Арслан Гиниятуллин on 12/11/22.
//

#include "mem.h"
#include "malloc_tests.h"

int main() {
    bool _1 = test_allocation();
    bool _2 = test_block_free();
    bool _3 = test_multiple_block_free();
    bool _4 = test_region_extends();
    bool _5 = test_region_does_not_extend();
    if (_1 && _2 && _3 && _4 && _5) {
        printf("SUCCESS");
        return TEST_PASS_SUCCESS;
    } else {
        printf("FAILED");
        return TEST_PASS_FAILED;
    }
}
