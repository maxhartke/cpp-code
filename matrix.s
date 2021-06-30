#
#   Name: Hartke, Max
#   Homework: #5
#   Due: April 14, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program to work with a 2-D array
#
        .data 
title:  .asciiz "Matrix by M. Hartke\n\n" 
row:    .asciiz "row? "
col:    .asciiz "col? "
NROWS = 6
NCOLS = 10
matrix: .word 0:NROWS*NCOLS

        .text
main:
        la      $a0, title      # output program heading
        li      $v0, 4
        syscall 

        li      $t0, 0          # row input: $t0
        li      $t1, 0          # col input: $t1
        li      $t2, 0          # output content: $t2
        li      $t3, 0          # array value: $t3
        li      $t4, 0          # [i]: $t4
        li      $t5, 0          # [j]: $t5
        li      $t6, 0          # effective offset: $t6

        la      $a0, row        # output row prompt
        li      $v0, 4
        syscall 
        li      $v0, 5          # read in row input
        syscall
        move    $t0, $v0
        la      $a0, col        # output col prompt
        li      $v0, 4
        syscall 
        li      $v0, 5          # read in col input
        syscall
        move    $t1, $v0
while:  
        addi    $t3, $t3, 1     # increment value stored in array
        la      $a0, matrix
        add     $a0, $a0, $t6
        sw      $t3, ($a0)      # matrix[$t4][$t5] = $t3
        addi    $t6, $t6, 4
        ble     $t3, 59, while 
       
output:
        mul     $t6, $t0, NCOLS # compute effective offset
        add     $t6, $t6, $t1
        sll     $t6, $t6, 2
        la      $a0, matrix
        add     $a0, $a0, $t6 
        lw      $t2, ($a0) 
        move    $a0, $t2        # return output content
        li      $v0, 1
        syscall 
exit:    
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        li      $v0, 10         # exit
        syscall


        .end    main