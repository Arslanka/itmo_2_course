//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_TRANSFORM_H
#define IMAGE_TRANSFORMER_TRANSFORM_H

#include "image.h"
#include <printer.h>
#include <stdint.h>

struct image rotate(const struct image *source, char rotate_degree);

#endif //IMAGE_TRANSFORMER_TRANSFORM_H
