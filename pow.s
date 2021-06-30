#
#   Name: Hartke, Max
#   Project: #4
#   Due: April 30, 2021 by 10 am
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program that computes and returns x^y using the pow recursive function
#
        .data
title:  .asciiz "Pow by M. Hartke\n"
descpt: .asciiz "n.....2^n\n"
dots:   .asciiz "....."
x = 2 
        .text

main:
        la	$a0, title      # display title
        li	$v0, 4
        syscall
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        la	$a0, descpt     # display description
        li	$v0, 4
        syscall
        li      $t0, 0          # t0: y
while:
        move    $a0, $t0        # print out y
        li      $v0, 1
        syscall
        la	$a0, dots       # display dots
        li	$v0, 4
        syscall
        li      $a0, x          # a0: x
        move    $a1, $t0        # a1: y
        jal     pow             # call pow
        move    $a0, $v0        # print out x^y
        li      $v0, 1
        syscall
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        addi    $t0, $t0, 1     # increment count
        bne     $t0, 10, while  # if < 10 then while 
exit: 
        li      $v0, 10         # exit
        syscall
        .end    main 
#
#       int pow(int x, int y)
#               returns x * pow(x, y -1)
#       Parameters:
#               a0: int x
#               a1: int y
#       Return value:
#               v0: x * pow(x, y -1)
#
pow:
        addiu   $sp, $sp, -16   # allocate space on stack
        sw      $ra, 12($sp)
        sw      $a0, 8($sp)
        sw      $a1, 4($sp)
        beqz    $a1, rtrn1      # if y = 0 then rtrn1
        addiu   $a1, $a1, -1    # subtract 1 from y
        jal     pow             # call pow
        lw      $a0, 8($sp)        
        lw      $a1, 4($sp)  
        mul     $v0, $v0, $a0   # multiply x by return value of pow
rtrn:   
        lw      $ra, 12($sp)
        addiu   $sp, $sp, 16
        jr      $ra             # return to main
rtrn1:                                        
        li      $v0, 1          # return 1
        b       rtrn            # return to rttn