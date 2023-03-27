//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_IMAGE_H
#define IMAGE_TRANSFORMER_IMAGE_H

#include  <stdint.h>

struct __attribute__((packed)) pixel {
    uint8_t red;
    uint8_t green;
    uint8_t blue;
};

struct image {
    uint32_t width, height;
    struct pixel *data;
};

struct image create_image(uint32_t width, uint32_t height);

void free_image(struct image image);

#endif //IMAGE_TRANSFORMER_IMAGE_H
