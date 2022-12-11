//
// Created by Арслан Гиниятуллин on 12/5/22.
//
#include "printer.h"

void print_message(FILE *source, char* matcher, const char *message) {
    fprintf(source, matcher, message);
}

void print_error(char* matcher, const char *message) {
    print_message(stderr, matcher, message);
}
