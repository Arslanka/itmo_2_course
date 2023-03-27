//
// Created by Арслан Гиниятуллин on 12/7/22.
//
#include "transform.h"


static struct image rotate_90(const struct image *const source) {
    const uint32_t width = source->height;
    const uint32_t height = source->width;
    const struct pixel *old_data = source->data;

    struct image result_image = create_image(width, height);
    struct pixel *new_data = result_image.data;

    for (size_t i = 0; i < width; ++i) {
        for (size_t j = 0; j < height; ++j) {
            new_data[j * width + (width - i - 1)] = old_data[i * height + j];
        }
    }
    return result_image;
}

struct image rotate(const struct image *source, char rotate_degree) {
    switch (rotate_degree) {
        case 90:
            return rotate_90(source);
        default:
            print_error("There is no functional for rotating image for %s rotate_degree\n", &rotate_degree);
            return rotate_90(source);
    }
}
