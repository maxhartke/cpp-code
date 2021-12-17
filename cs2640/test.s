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
