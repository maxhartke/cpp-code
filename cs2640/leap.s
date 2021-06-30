#
#   Name: Hartke, Max
#   Project: #2
#   Due: March 19, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program that outputs the leap years between a starting and an ending years.
#
        .data
prompt: .asciiz "Leap Years by M. Hartke\n\n"
yrfrom: .asciiz "Enter from year? "
yrto:   .asciiz "Enter to year? "
end1:   .asciiz "Leap years from "
end2:   .asciiz " to "
end3:   .asciiz ":\n"

        .text
main:
        la	$a0, prompt     # display prompt
        li	$v0, 4 		# $v0  4 = print prompt
        syscall

        li      $t0, 0          # Year from: $t0
        li      $t1, 0          # Year to: $t1
        li      $t2, 0          # current year: $t2
        li      $t3, 400        # 400: $t3
        li      $t4, 100        # 100: $t4
        li      $t5, 4          # 4: $t5

        la	$a0, yrfrom     # display yrfrom
        li	$v0, 4
        syscall
        li	$v0, 5  	# $v0  5 = read int
        syscall
        move    $t0, $v0        # move yearfrom to $t0

        la	$a0, yrto       # display yrto
        li	$v0, 4
        syscall
        li	$v0, 5  	# $v0  5 = read int
        syscall
        move    $t1, $v0        # move yearto to $t1
        move    $t2, $t0        # Move first year into current year

        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
output:
        la	$a0, end1       # display end1
        li	$v0, 4
        syscall
        move    $a0, $t0        # output yearfrom
        li      $v0, 1
        syscall
        la      $a0, end2       # display end2
        li	$v0, 4
        syscall
        move    $a0, $t1        # output yearto
        li      $v0, 1
        syscall
        la	$a0, end3       # display end3
        li      $v0, 4
        syscall
while:
        rem     $t6, $t2, $t3   # Divide current year by 400
        beqz    $t6, leapyr     # If == 0, then leap year
        rem     $t6, $t2, $t4   # Divide current year by 100
        beqz    $t6, repeat     # If ==0, then not leap year
        rem     $t6, $t2, $t5   # Divide current year by 4
        bnez    $t6, repeat     # If != 0, then not leap year
leapyr:
        move    $a0, $t2        # output leap year
        li      $v0, 1
        syscall
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
repeat:
        sub     $t7, $t1, $t2   # subtract last year from current year
        beqz    $t7, exit       # if data == 0, done
        add     $t2, $t2, 1     # increment year
        b	while		# branch to while

exit:
        li	$v0, 10         # $v0  10 = exit
        syscall

        .end    main
