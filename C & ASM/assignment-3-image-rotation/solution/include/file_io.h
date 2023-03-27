//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_FILE_IO_H
#define IMAGE_TRANSFORMER_FILE_IO_H

#include "file_io_status_codes.h"
#include <stdio.h>

enum open_status open_file(FILE **file, const char *filename, const char *mode);

enum close_status close_file(FILE *file);

#endif //IMAGE_TRANSFORMER_FILE_IO_H
