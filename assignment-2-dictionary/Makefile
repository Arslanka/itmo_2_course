ASM=nasm
ASM_FLAGS=-f elf64
LD=ld
	
main.o: main.asm
	$(ASM) $(ASM_FLAGS) -o main.o main.asm

%.o: %.asm
	$(ASM) $(ASM_FLAGS) -o $@ $<

main: main.o dict.o lib.o
	$(LD) -o main $^

.PHONY: clean
clean:
	rm *.o
