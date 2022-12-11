%define PSIZE 8

global find_word
extern string_equals

section .text

find_word:
    add rsi, PSIZE
    push rsi
    push rdi
    call string_equals
    pop rdi
    pop rsi

    sub rsi, PSIZE

    test rax, rax
    jnz .success

    mov rsi, [rsi]
    test rsi, rsi
    jnz find_word

    xor rax, rax
    ret

.success:
    mov rax, rsi
    ret
