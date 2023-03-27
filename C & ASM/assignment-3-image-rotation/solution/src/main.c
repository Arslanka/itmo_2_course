#include "bmp_io.h"
#include "file_io.h"
#include "file_io_status_codes.h"
#include "printer.h"
#include "transform.h"
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
    if (argc != 3) {
        printf("%d args were given, but was expected 2. Usage example: image-transformer <input.bmp> <output.bmp>\n",
               argc - 1);
        return EXIT_FAILURE;
    }
    const char *input_file_path = argv[1];
    FILE *input_file = NULL;

    const enum open_status open_input_status = open_file(&input_file, input_file_path, "rb");
    if (open_input_status != OPEN_OK) {
        print_error("Error occurred while file opening. Status is %s\n", OPEN_STATUS_MESSAGES[open_input_status]);
        return EXIT_FAILURE;
    }

    struct image image = {0};
    const enum read_status read_input_status = from_bmp(input_file, &image);
    if (read_input_status != READ_OK) {
        print_error("Error occurred while file reading. Status is %s\n", READ_STATUS_MESSAGES[read_input_status]);
        return EXIT_FAILURE;
    }

    const enum close_status close_input_status = close_file(input_file);
    if (close_input_status != CLOSE_OK) {
        print_error("Error occurred while file closing. Status is %s\n", CLOSE_STATUS_MESSAGES[close_input_status]);
        free_image(image);
        return EXIT_FAILURE;
    }

    const char *output_file_path = argv[2];
    FILE *output_file = NULL;
    enum open_status open_output_status = open_file(&output_file, output_file_path, "wb");
    if (open_output_status != OPEN_OK) {
        print_error("Error occurred while file opening. Status is %s\n", OPEN_STATUS_MESSAGES[open_output_status]);
        free_image(image);
        return EXIT_FAILURE;
    }

    struct image rotated_image = rotate(&image, 90);
    const enum write_status write_output_status = to_bmp(output_file, &rotated_image);
    if (write_output_status != WRITE_OK) {
        print_error("Error occurred while file writing. Status is %s\n", WRITE_STATUS_MESSAGES[write_output_status]);
        free_image(image), free_image(rotated_image);
        return EXIT_FAILURE;
    }

    const enum close_status close_output_status = close_file(output_file);
    if (close_output_status != CLOSE_OK) {
        print_error("Error occurred while file closing. Status is %s\n", CLOSE_STATUS_MESSAGES[close_output_status]);
        free_image(image), free_image(rotated_image);
        return EXIT_FAILURE;
    }
    free_image(image), free_image(rotated_image);
    return EXIT_SUCCESS;
}
