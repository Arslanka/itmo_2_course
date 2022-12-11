//
// Created by Арслан Гиниятуллин on 12/7/22.
//

#include "bmp_io.h"
#include "file_io_status_codes.h"

const char *const OPEN_STATUS_MESSAGES[] = {
        [OPEN_OK] = "File opened successfully",
        [OPEN_ERROR] = "File open error"
};

const char *const CLOSE_STATUS_MESSAGES[] = {
        [CLOSE_OK] = "File was closed successfully",
        [CLOSE_ERROR] = "File close error"
};

const char *const READ_STATUS_MESSAGES[] = {
        [READ_OK] = "Image was read successfully",
        [READ_INVALID_BITS] = "Bits read error",
        [READ_INVALID_HEADER] = "Header read error",
        [READ_INVALID_SIGNATURE] = "Image signature error",
};

const char *const WRITE_STATUS_MESSAGES[] = {
        [WRITE_OK] = "Image was written successfully",
        [WRITE_ERROR] = "Image write error"
};
