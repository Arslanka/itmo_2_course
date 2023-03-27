ASM=nasm
ASM_FLAGS=-f elf64
LD=ld

SRC_DIR=.
RES_DIR=res
EXECUTABLE=main

SOURCES := $(wildcard $(SRC_DIR)/*.asm)
RESULT  := $(SOURCES:$(SRC_DIR)/%.asm=$(RES_DIR)/%.o)

$(RESULT): $(RES_DIR)/%.o : $(SRC_DIR)/%.asm
        @mkdir -p $(@D)
        $(ASM) $(ASM_FLAGS) $< -o $@

$(EXECUTABLE): $(RESULT)
        $(LD) $(RESULT) -o $@

.PHONY: clean
clean:
    $(RM) -rf $(RES_DIR)/*.o $(EXECUTABLE)
