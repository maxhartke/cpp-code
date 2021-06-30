#
#   Name: Hartke, Max
#   Homework: #3
#   Due: March 17, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program to compute the day of the week for a given date in the Gregorian calendar
#

        .data
title:  .asciiz "Dow by M. Hartke\n\n"
day:    .word 15
month:  .word 3
year:   .word 2021
dow:    .word 0

        .text
main:
        la      $a0, title      #output program heading
        li      $v0, 4
        syscall

        li      $t0, 0          #a: $t0
        li      $t1, 0          #y: $t1
        li      $t2, 0          #m: $t2
        li      $t6, 0          #d: $t6
calca:
        li      $t3, 14         #Load 14 in $t3
        lw      $t4, month      #Load month in $t4
        sub     $t0, $t3, $t4   #Subtract month from 14
        li      $t4, 12
        move    $a0, $t0
        div     $t0, $t0, $t4
calcy:
        lw      $t4, year       #Load year in $t4
        sub     $t1, $t4, $t0   #Subtract a from year and store in y
calcm:
        lw      $t2, month      #Load month in m
        li      $t4, 12         #Load 12 in $t4
        mul     $t5, $t4, $t0   #Multiply a by 12
        add     $t2, $t2, $t5   #Add $t5 to m
        sub		$t2, 2          #Subtract 2 from m
calcd:
        lw      $t6, day        #Load day in d
        add     $t6, $t6, $t1   #Add y to d

        li      $t3, 4          #Load 4 in $t3
        div     $t4, $t1, $t3   #Divide y by 4
        add     $t6, $t6, $t4   #Add y/4 to d

        li      $t3, 100        #Load 100 in $t3
        div     $t4, $t1, $t3   #Divide y by 100
        sub     $t6, $t6, $t4   #Subtract from d

        li      $t3, 400        #Load 400 in $t3
        div     $t4, $t1, $t3   #Divide y by 400
        add     $t6, $t6, $t4   #Add y/400 to d

        li      $t3, 31         #Load 31 in $t3
        mul     $t2, $t2, $t3   #Multiply m by 31
        li      $t3, 12         #Load 12 in $t3
        div     $t2, $t2, $t3   #Divide 31*m by 12
        add     $t6, $t6, $t2   #Add (31*m)/12 to d

        li      $t3, 7          #Load 7 in $t3
        div     $t6, $t3        #Modulo by 7

        mfhi    $t6             #Move hi to $t6
        sw      $t6, dow        #Move d to dow

        lw      $a0, dow        #output dow
        li      $v0, 1
        syscall
        li      $a0, '\n'       #new line
        li      $v0, 11
        syscall

exit:   li      $v0, 10         #exit
        syscall


        .end    main
