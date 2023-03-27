//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_FILE_IO_STATUS_CODES_H
#define IMAGE_TRANSFORMER_FILE_IO_STATUS_CODES_H

enum open_status {
    OPEN_OK,
    OPEN_ERROR,
};

enum close_status {
    CLOSE_OK,
    CLOSE_ERROR,
};

extern const char *const OPEN_STATUS_MESSAGES[];
extern const char *const CLOSE_STATUS_MESSAGES[];

#endif //IMAGE_TRANSFORMER_FILE_IO_STATUS_CODES_H
