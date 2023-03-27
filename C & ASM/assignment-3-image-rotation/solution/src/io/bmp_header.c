//
// Created by Арслан Гиниятуллин on 12/7/22.
//
#include "bmp_header.h"

#define DEFAULT_BF_TYPE 0x4d42
#define DEFAULT_BI_SIZE 40
#define DEFAULT_X_PELS_PER_METER 3400
#define DEFAULT_Y_PELS_PER_METER 3400
#define DEFAULT_BIT_COUNT 24

struct bmp_header create_default_bmp_header(void) {
    return (struct bmp_header) {
            .bfType = DEFAULT_BF_TYPE,
            .bfReserved = 0,
            .bOffBits = sizeof(struct bmp_header),
            .biSize = DEFAULT_BI_SIZE,
            .biPlanes = 1,
            .biCompression = 0,
            .biXPelsPerMeter = DEFAULT_X_PELS_PER_METER,
            .biYPelsPerMeter = DEFAULT_Y_PELS_PER_METER,
            .biBitCount = DEFAULT_BIT_COUNT,
            .biClrUsed = 0,
            .biClrImportant = 0,
    };
}
