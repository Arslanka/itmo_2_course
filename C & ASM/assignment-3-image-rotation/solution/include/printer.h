//
// Created by Арслан Гиниятуллин on 12/5/22.
//

#ifndef IMAGE_TRANSFORMER_PRINTER_H
#define IMAGE_TRANSFORMER_PRINTER_H

#include <stdio.h>

void print_message(FILE *source, char *matcher, const char *message);

void print_error(char *matcher, const char *message);

#endif //IMAGE_TRANSFORMER_PRINTER_H
