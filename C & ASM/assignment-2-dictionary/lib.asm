%define newline  0xA
%define ascii_minus 45

global exit
global string_length
global print_string
global print_char
global print_newline
global print_uint
global print_int
global print_error
global string_equals
global read_char
global read_word
global read_string
global parse_uint
global parse_int
global string_copy

section .text
 
 
; Принимает код возврата и завершает текущий процесс
exit: 
    mov rax, 60
    syscall
    
; Принимает указатель на нуль-терминированную строку, возвращает её длину
string_length:
    xor rax, rax
    .loop:
        cmp byte [rdi + rax], 0
        je .end
        inc rax
        jmp .loop
    .end:
        ret

; Принимает указатель на нуль-терминированную строку, выводит её в stdout
print_string:
    call string_length
    mov rdx, rax
    mov rsi, rdi
    mov rax, 1
    mov rdi, 1
    syscall
    ret

; Принимает код символа и выводит его в stdout
print_char:
    push rdi
    mov rsi, rsp
    mov rax, 1
    mov rdi, 1
    mov rdx, 1
    syscall
    pop rax
    ret

; Переводит строку (выводит символ с кодом 0xA)
print_newline:
    mov rdi, newline
    call print_char

; Выводит беззнаковое 8-байтовое число в десятичном формате 
; Совет: выделите место в стеке и храните там результаты деления
; Не забудьте перевести цифры в их ASCII коды.
print_uint:
    xor rcx, rcx

    mov rax,rdi
    mov rdi,10
    mov r8, rsp
    push 0

    .get_digits:
        xor rdx, rdx
        div rdi
        add rdx, '0'
        dec rsp
        mov byte[rsp], dl
        cmp rax,0
        je .next
        jmp .get_digits

    .next:
        mov rdi, rsp
        push r8
        call print_string
        pop rsp
        ret

; Выводит знаковое 8-байтовое число в десятичном формате 
print_int:
    test rdi, rdi
    jnl .plus
    push rdi
    mov rdi, '-'
    call print_char
    pop rdi
    neg rdi

    .plus:
	    call print_uint
        ret

; Принимает два указателя на нуль-терминированные строки, возвращает 1 если они равны, 0 иначе
string_equals:
    xor rcx, rcx

    .loop:
        mov dl, byte [rdi + rcx]
        cmp dl, byte [rsi + rcx]
        jne .not_equals
        test dl, dl
        jz .equals
        inc rcx
        jmp .loop

    .equals:
    mov rax, 1
        ret

    .not_equals:
    mov rax, 0
        ret

; Читает один символ из stdin и возвращает его. Возвращает 0 если достигнут конец потока
read_char:
    xor rax, rax
    xor rdi, rdi
    mov rdi, 0
    push 0
    mov rsi, rsp
    mov rdx, 1
    syscall
    pop rax
    ret 

; Принимает: адрес начала буфера, размер буфера
; Читает в буфер слово из stdin, пропуская пробельные символы в начале, .
; Пробельные символы это пробел 0x20, табуляция 0x9 и перевод строки 0xA.
; Останавливается и возвращает 0 если слово слишком большое для буфера
; При успехе возвращает адрес буфера в rax, длину слова в rdx.
; При неудаче возвращает 0 в rax
; Эта функция должна дописывать к слову нуль-терминатор

read_word:
    xor rdx, rdx
    dec rsi

    .read_char:
    	push rdi
    	push rsi
    	push rdx
    	call read_char
    	pop rdx
    	pop rsi
    	pop rdi
    	lea r8, [rax-9]
    	cmp r8, 1
    	jbe .is_end
    	cmp al, ' '
    	je .is_end
    	cmp rdx, rsi
    	ja .long_enough
    	mov byte [rdi+rdx], al
    	test al, al
    	jz .word_end
    	inc rdx
    	jmp .read_char

    .is_end:
    	test rdx, rdx
    	jz .read_char

    .word_end:
    	mov rax, rdi
    	ret

    .long_enough:
    	xor rax, rax
    	ret

; Принимает указатель на строку, пытается
; прочитать из её начала беззнаковое число.
; Возвращает в rax: число, rdx : его длину в символах
; rdx = 0 если число прочитать не удалось
parse_uint:
    xor rax, rax
    xor rcx, rcx
    xor rdx, rdx

    .read_digit:
    	mov cl, byte [rdi+rdx]
    	xor cl, '0'
    	cmp cl, 9
    	ja .end
    	lea rax, [rax * 4 + rax]
    	lea rax, [rax * 2 + rcx]
    	inc rdx
    	jmp .read_digit
    .end:
	    ret

; Принимает указатель на строку, пытается
; прочитать из её начала знаковое число.
; Если есть знак, пробелы между ним и числом не разрешены.
; Возвращает в rax: число, rdx : его длину в символах (включая знак, если он был) 
; rdx = 0 если число прочитать не удалось
parse_int:
     mov cl, byte [rdi]
     cmp cl, ascii_minus
     jne .if_positive
     jmp .if_negative

    .if_positive:
	    call parse_uint
	    jmp .end

    .if_negative:
	    inc rdi
	    call parse_uint
	    neg rax
	    inc rdx
    .end: 
	    ret 

; Принимает указатель на строку, указатель на буфер и длину буфера
; Копирует строку в буфер
; Возвращает длину строки если она умещается в буфер, иначе 0
string_copy:
    xor rax, rax
    call string_length
    cmp rax, rdx
    ja .not_equals
    mov rcx, 0

    .loop:
	    mov r8b, byte [rdi + rcx]
	    mov byte [rsi + rcx], r8b
	    cmp rcx, rax
	    je .end
	    inc rcx
	    jmp .loop

    .end:
	    ret

    .not_equals:
	    mov rax, 0  
    	ret

read_string:
    mov r8, rdi
    mov r9, rsi
    mov r10, r8
    mov rcx, 0
    cmp rsi, 0
    je .end
    .loop_until_not_space:
       push rcx
       call read_char
       pop rcx
       mov rdi, r10
       mov rsi, r9
       cmp rax, ' '
       je .loop_until_not_space
       cmp rax, '   '
       je .loop_until_not_space
    .mainloop:
       cmp rax, 0
       je .add_null_and_end
       cmp rax, NEW_LINE_SYMBOL
       je .add_null_and_end
       mov byte [r8], al
       inc r8
       inc rcx
       cmp rcx, rsi
       je .end
       push rcx
       call read_char
       pop rcx
       mov rdi, r10
       mov rsi, r9
       jmp .mainloop
    .add_null_and_end:
       mov byte [r8], 0
       mov rax, r10
       mov rdx, rcx
       ret
    .end:
       mov rax, 0
       ret

print_error:
    xor rax, rax
    mov rsi, rdi
    call string_length
    mov rdx, rax
    mov rax, 1
    mov rdi, 2
    syscall
    ret

