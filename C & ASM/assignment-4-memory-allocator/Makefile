CC=gcc
CFLAGS=--std=c17 -Wall -pedantic -Isrc/ -ggdb -Wextra -Werror -DDEBUG
BUILD=build
SRC=src
BIN=bin
OBJS=$(BUILD)/main.o $(BUILD)/util.o  $(BUILD)/mem.o $(BUILD)/mem_debug.o

$(BUILD)/%.o: $(SRC)/%.c build
	$(CC) -c $(CFLAGS) $< -o $@

compile: $(OBJS) bin
	$(CC) -o $(BIN)/main $(OBJS)

clean:
	rm -rf $(BUILD)

build:
	mkdir -p $(BUILD)

bin:
	mkdir -p $(BIN)

run: compile
	$(BIN)/main
