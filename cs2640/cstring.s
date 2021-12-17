#
#       Name: Hartke, Max
#       Homework: #6
#       Due: April 23, 2021
#       Course: cs-2640-01-sp21
#       
#       Description:
#               Program to compute return length of cstring
#

        .data
title:  .asciiz "String by M. Hartke\n\n"
prompt: .asciiz "Enter a string? "
colon:  .asciiz ":"
LINELEN = 81
inbuf:  .space LINELEN

        .text
main:
        la      $a0, title      # output program heading
        li      $v0, 4
        syscall
        la      $a0, prompt     # output prompt
        li      $v0, 4
        syscall
        la      $a0, inbuf      # a0: inbuf
        jal     gets            # call gets
        jal     strlen          # call strlen
#
#       int gets(address buf, int size)
#               reads a cstring from the keyboard into buf, use syscall 8
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
#               t1: length of cstring
#
strlen:
        li      $t1, 0          # $t1: count
while:
        lb      $t2, 0($a0)     # $t2: pointer
        beqz    $t2, print      # if 0 then print
        addiu   $a0, $a0, 1     # increment byte 
        addiu   $t1, $t1, 1     # increment count
        j       while
print:
        move    $a0, $t1        
        li      $v0, 1          # output length
        syscall
        la      $a0, colon      # output colon
        li      $v0, 4
        syscall
        la      $a0, inbuf      # output inbuf
        li      $v0, 4
        syscall
exit:   
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        li      $v0, 10         # exit
        syscall
        .end    main 
