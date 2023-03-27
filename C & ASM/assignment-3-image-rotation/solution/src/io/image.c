//
// Created by Арслан Гиниятуллин on 12/7/22.
//

#include "image.h"
#include <stdlib.h>

struct image create_image(uint32_t width, uint32_t height) {
    struct pixel *pixels = malloc(sizeof(struct pixel) * width * height);
    struct image result = (struct image) {.height = height, .width = width, .data = pixels};
    return result;
}

void free_image(struct image image) {
    free(image.data);
}
