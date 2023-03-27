//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_BMP_IO_H
#define IMAGE_TRANSFORMER_BMP_IO_H

#include "bmp_header.h"
#include <stdio.h>

/*  deserializer   */

enum read_status {
    READ_OK = 0,
    READ_INVALID_SIGNATURE,
    READ_INVALID_BITS,
    READ_INVALID_HEADER
    /* коды других ошибок  */
};

/*  serializer   */
enum write_status {
    WRITE_OK = 0,
    WRITE_ERROR
    /* коды других ошибок  */
};

extern const char *const READ_STATUS_MESSAGES[];
extern const char *const WRITE_STATUS_MESSAGES[];

enum read_status from_bmp(FILE *input, struct image *image);

enum write_status to_bmp(FILE *output, struct image *image);

enum read_status read_header(FILE *input, struct bmp_header *header);

enum read_status read_pixels(FILE *input, struct image *const image);

enum write_status write_header(FILE *output, struct image *image);

enum write_status write_pixels(FILE *output, const struct image *const image);

#endif //IMAGE_TRANSFORMER_BMP_IO_H
