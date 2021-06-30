#
#   Name: Hartke, Max
#   Homework: #4
#   Due: March 24, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program to compute and output the average of an integer array.
#
        .data 
title:  .asciiz "Array by M. Hartke\n\n" 
array:  .word 41, 2, 80, 85, 57, 24, 6, 71
	.word 82, 72, 81, 29, 98, 48, 91, 2
	.word 81, 39, 11, 44, 95, 42, 13, 16
	.word 7, 14, 52, 18, 8, 25, 47, 49
	.word 78, 26, 85, 34, 49, 43, 57, 82
	.word 14, 37, 10, 63, 37, 52, 65, 17
	.word 91, 75, 12, 37, 68, 24, 5, 74
	.word 89, 8, 91, 97, 32, 89, 97, 10
	.word 66, 33, 95, 14, 75, 51, 47, 88
	.word 40, 56, 51, 76, 8, 67, 44, 50
	.word 41, 55

        .text
main:
        la      $a0, title      # output program heading
        li      $v0, 4
        syscall

        li      $t0, 0          # total: $t0
        li      $t1, 0          # count: $t1
        li      $t3, 0          # current array element: $t3
while:
        lw      $t3, array($s1) # load in array element
        beqz    $t3, exit       # if current element = 0 then done
        add     $t0, $t0, $t3   # add to total
        add     $t1, $t1, 1     # increment count
        add     $s1, $s1, 4     # increment index by 4
        b       while

exit:   
        div     $a0, $t0, $t1   # Divide total by count
        li      $v0, 1          # Output result
        syscall
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        li      $v0, 10         # exit
        syscall


        .end    main