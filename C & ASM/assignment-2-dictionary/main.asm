%include "lib.inc"
%include "colon.inc"
%include "words.inc"
%assign MAX_KEY_SIZE 255
%define OFFSET 8

section .rodata
error: db 'error', 0

section .bss
key: times MAX_KEY_SIZE db 0

section .text
global _start

_start:
  mov rsi, MAX_KEY_SIZE
  mov rdi, key
  
  call read_string
  cmp rax, 0
  je .err
  
  mov rdi, rax
  mov rsi, first_word 
  call find_word
  cmp rax, 0
  je .err
  add rax, OFFSET
  mov rdi, rax
  push rdi
  call string_length
  inc rax
  pop rdi
  add rdi, rax
  .success:
    call print_string
    jmp exit
  .err:
    mov rdi, error
    call print_error
    jmp exit
