#
#   Name: Hartke, Max
#   Project: #3
#   Due: April 26, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program that implements an array to store input lines of text
#
        .data
title:  .asciiz "Lines by M. Hartke\n\n"
prompt: .asciiz "Enter text? "
MAXLINES = 10 
LINELEN = 32
lines: .word 0:MAXLINES
inbuf: .space LINELEN

        .text

main:
        la	$a0, title      # display title
        li	$v0, 4
        syscall
        li      $s0, 0          # s0: counter
        la      $s1, lines      # s1: lines
do:
        la	$a0, prompt     # display prompt
        li	$v0, 4
        syscall
        la      $a0, inbuf      # load in inbuf
        jal     gets            # call gets(inbuf)
        lb      $t0, inbuf      # Load first byte
        beq     $t0, '\n', prnt # if \n then prnt
        addi    $s0, $s0, 1     # increment counter
        la      $a0, inbuf      # load in inbuf
        jal     strdup          # call strdup(inbuf)
        sw      $v0, ($s1)      # store address of input in lines           
        addi    $s1, $s1, 4     # increment lines
        ble     $s0, 9, do      # if count <= 9 then do
prnt:
        la      $s1, lines      # load in lines
loop:
        beqz    $s0, exit       # if count = 0 then exit
        lw      $a0, ($s1)      # load first element of array
        jal     puts            # call puts(lines[s0])
        addi    $s1, $s1, 4     # increment lines
        sub     $s0, $s0, 1     # decrement counter
        b       loop
exit:
        li      $v0, 10         # exit
        syscall
        .end    main    
#
#       int gets(address buf, int size)
#               reads a cstring from the keyboard into buf, uses syscall 8
#       Parameters:
#               a0: address
#
gets:
        li      $v0, 8          # read string
        syscall
        jr      $ra             # return to main
#
#       int strlen(cstring cs)
#               returns the length of cs, not including ‘\0’
#       Parameters:
#               a0: cstring
#       Return value:
#               v0: length of cstring
#
strlen:
        li      $v0, 0          # v0: count
while:
        lb      $t0, 0($a0)     # $t0: pointer
        beqz    $t0, endw       # if 0 then break
        addiu   $a0, $a0, 1     # increment byte 
        addiu   $v0, $v0, 1     # increment count
        b       while  
endw:
        jr      $ra             # return to srtdup
#
#       address malloc(int size) 
#               Allocates a block of size bytes of dynamic memory, uses syscall 9
#       Parameters:
#               a0: size
#       Return value:
#               v0: the address to the beginning of the block
#
malloc:
        addi    $a0, $a0, 3     # verfify parameter is multiple of 4
        srl     $a0, $a0, 2
        sll     $a0, $a0, 2
        li      $v0, 9          # allocate memory
        syscall
        jr      $ra             # return to strdup
#
#       cstring strdup(cstring source)
#               returns the address of the duplicated source
#       Parameters: 
#               a0: source
#       Return value:
#               v0: the address of the duplicated source
#
strdup:
        addiu   $sp, $sp, -8    # allocate space on the stack
        sw      $ra, ($sp)      # store return address in allocated space
        sw      $a0, 4($sp)     # store source in allocated space
        jal     strlen          # call strlen(inbuf)
        addiu   $a0, $v0, 1     # add 1 to string length
        jal     malloc          # call malloc(length of cstring)
        lw      $a0, 4($sp)     # load source
        move    $t0, $v0        # t0: address to the beginning of the block
copy:
        lb      $t1, 0($a0)     # t1: pointer
        beqz    $t1, end        # if 0 then end
        sb      $t1, 0($t0)     # store byte 
        addiu   $a0, $a0, 1     # increment byte
        addiu   $t0, $t0, 1     # increment byte 
        b       copy
end:  
        lw      $ra, ($sp)      # return to main
        addiu   $sp, $sp, 8 
        jr      $ra
#
#       void puts(cstring source) 
#               output source to the terminal, uses syscall 4
#       Parameters:
#               a0: source
#
puts:     
        li      $v0, 4          # output element
        syscall
        jr      $ra             # return to main