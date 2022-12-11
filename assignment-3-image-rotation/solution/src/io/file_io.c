#include "file_io.h"

//
// Created by Арслан Гиниятуллин on 12/5/22.
//
enum open_status open_file(FILE **file, const char *filename, const char *mode) {
    *file = fopen(filename, mode);
    if (*file) return OPEN_OK;
    return OPEN_ERROR;
}

enum close_status close_file(FILE *file) {
    if (fclose(file)) return CLOSE_ERROR;
    return CLOSE_OK;

}
