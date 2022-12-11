//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_BMP_HEADER_H
#define IMAGE_TRANSFORMER_BMP_HEADER_H

#include "image.h"
#include  <stdint.h>

struct __attribute__((packed)) bmp_header {
    uint16_t bfType;
    uint32_t bfileSize;
    uint32_t bfReserved;
    uint32_t bOffBits;
    uint32_t biSize;
    uint32_t biWidth;
    uint32_t biHeight;
    uint16_t biPlanes;
    uint16_t biBitCount;
    uint32_t biCompression;
    uint32_t biSizeImage;
    uint32_t biXPelsPerMeter;
    uint32_t biYPelsPerMeter;
    uint32_t biClrUsed;
    uint32_t biClrImportant;
};

struct bmp_header create_default_bmp_header(void);

#endif //IMAGE_TRANSFORMER_BMP_HEADER_H
