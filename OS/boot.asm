SECTION MBR vstart=0x7c00
    mov ax, cs
    mov ds, ax
    mov es, ax
    mov gs, ax
    mov fs, ax
    mov ss, ax
    mov sp, 0x7c00          ;stack pointer value, it's important

    ;clear screen
    mov ax, 0x600
    mov bx, 0x700
    mov cx, 0
    mov dx, 0x184f

    int 0x10

    ;get current cursor
    mov ah, 0x03        ;function number
    mov bh, 0x00
    int 0x10

    ;print chars in screen
    mov ax, msg
    mov bp, ax          ;es:bp-->the first address of string
    
    mov cx, 20
    mov ah, 0x13        ;function number, print char 
    mov al, 0x01        ;print char and mov cursor
    mov bh, 0x00        ;page number
    mov bl, 0x02        ;char attribute, black bootom and green font
    int 0x10

    jmp $

    msg     db      "this is a simple OS!"
    times 510 - ($ - $$) db 0
    db 0x55, 0xaa

