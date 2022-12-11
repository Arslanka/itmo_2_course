//
// Created by Арслан Гиниятуллин on 12/7/22.
//
#include "bmp_padding.h"
#include "image.h"

uint32_t get_padding(const uint32_t width) {
    uint32_t padding = width * sizeof(struct pixel) % 4;
    if (padding) {
        return 4 - padding;
    }
    return 0;
}
