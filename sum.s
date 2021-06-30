#
#   Name: Hartke, Max
#   Homework: #2
#   Due: March 12, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program to compute and output the count and the average.
#
        .data
title:  .asciiz "Sum by M. Hartke\n\nEnter data, use 0 to end input.\n\n"
prompt: .asciiz "? "
sumis:  .asciiz "\nThe sum is "
count:  .asciiz "\nThe count is "
avrg:   .asciiz "\nThe average is "
null:   .asciiz "\nNo data entered\n"

        .text
main:
        la      $a0, title      #output program heading
        li      $v0, 4
        syscall

        li      $t0, 0          #sum:t0
        li      $t1, 0          #count: t1
while:
        la      $a0, prompt     #display prompt
        li      $v0, 4
        syscall
        la      $v0, 5          #read data
        syscall
        beqz    $v0, endw       #if data == 0, done

        add     $t0, $t0, $v0   #add input to sum
        add     $t1, $t1, 1     #incrment count
        b       while
endw:
        beqz    $t1, empty      #if count == 0, No data entered
        la      $a0, sumis      #output sum text
        li      $v0, 4
        syscall
        move    $a0, $t0        #output sum
        li      $v0, 1
        syscall
        la      $a0, count      #output count text
        li      $v0, 4
        syscall
        move    $a0, $t1        #output count
        li      $v0, 1
        syscall
        la      $a0, avrg       #output average text
        li      $v0, 4
        syscall
        div    $a0, $t0, $t1    #output average
        li      $v0, 1
        syscall
        li      $a0, '\n'       #new line
        li      $v0, 11
        syscall
empty:
        bnez    $t1, exit       #if count != 0, exit
        la      $a0, null       #output null text
        li      $v0, 4
        syscall
        li      $a0, '\n'       #new line
        li      $v0, 11
        syscall

exit:   li      $v0, 10         #exit
        syscall


        .end    main
