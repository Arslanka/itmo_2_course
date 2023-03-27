//
// Created by Арслан Гиниятуллин on 12/7/22.
//
#include <bmp_io.h>
#include <bmp_padding.h>

static struct bmp_header to_bmp_header(struct image *image) {
    struct bmp_header header = create_default_bmp_header();
    header.biHeight = image->height;
    header.biWidth = image->width;
    header.biSizeImage = sizeof(struct pixel) * image->height * image->width;
    header.bfileSize = header.biSizeImage + sizeof(struct bmp_header);
    return header;
}

enum read_status read_header(FILE *input, struct bmp_header *header) {
    const size_t read_result = fread(header, sizeof(struct bmp_header), 1, input);
    if (read_result != 1) return READ_INVALID_HEADER;
    return READ_OK;
}

enum read_status read_pixels(FILE *input, struct image *const image) {
    const uint32_t width = image->width;
    const uint32_t padding = get_padding(width);
    struct pixel *const pixels = image->data;
    for (size_t i = 0; i < image->height; ++i) {
        size_t pixels_count = fread(width * i + pixels, sizeof(struct pixel), width, input);
        if (pixels_count != width) return READ_INVALID_BITS;
        int skipped_bytes_count = fseek(input, padding, SEEK_CUR);
        if (skipped_bytes_count != 0) return READ_INVALID_BITS;
    }
    return READ_OK;
}

enum read_status from_bmp(FILE *input, struct image *image) {
    struct bmp_header header = create_default_bmp_header();
    const enum read_status read_status = read_header(input, &header);
    if (read_status != READ_OK) {
        return read_status;
    }
    *image = create_image(header.biWidth, header.biHeight);
    return read_pixels(input, image);
}

enum write_status write_header(FILE *output, struct image *image) {
    struct bmp_header header = to_bmp_header(image);
    const size_t written_header_bytes_count = fwrite(&header, sizeof(struct bmp_header), 1, output);
    if (written_header_bytes_count != 1) {
        return WRITE_ERROR;
    }
    return WRITE_OK;
}

enum write_status write_pixels(FILE *output, const struct image *const image) {
    const uint32_t width = (image->width);
    const uint32_t padding = get_padding(width);
    for (size_t i = 0; i < image->height; ++i) {
        size_t data_written_count = fwrite(width * i + image->data, sizeof(struct pixel), width, output);
        if (data_written_count != width) {
            return WRITE_ERROR;
        }

        size_t zero_written_count = fwrite(image->data, sizeof(char), padding, output);
        if (zero_written_count != padding) {
            return WRITE_ERROR;
        }
    }
    return WRITE_OK;
}

enum write_status to_bmp(FILE *output, struct image *image) {
    const enum write_status write_status = write_header(output, image);
    if (write_status != WRITE_OK) {
        return write_status;
    }
    return write_pixels(output, image);;
}

