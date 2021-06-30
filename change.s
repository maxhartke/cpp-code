#
#   Name: Hartke, Max
#   Project: #1
#   Due: March 12, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program that tells what coins to give out for any amount of change from 1 cent to 99 cents. For
#               example, if the amount is 86 cents, the change would be 3 quarters, 1 dime. and 1 penny.
#
        .data
prompt: .asciiz "Change by M. Hartke\n\nEnter the change? "
qtr:    .asciiz "\nQuarter: "
dime:   .asciiz "\nDime: "
nickle: .asciiz "\nNickel: "
penny:  .asciiz "\nPenny: "

        .text
main:
        la	$a0, prompt     # display prompt
        li	$v0, 4 		# $v0  4 = print prompt
        syscall
        li	$v0, 5  	# $v0  5 = read int
        syscall

        li      $t5, 0          # total: $t5
        li	$t0, 0 		# qtr: $t0
        li	$t1, 0 		# dime: $t1
        li      $t2, 0          # nickle: $t2
        li      $t3, 0          # penny: $t3

        move    $t5, $v0        # move input to $t5
        div     $t0, $t5, 25    # div by qrt
        rem     $t5, $t5, 25    # move remainder to $t5
        div     $t1, $t5, 10    # div by dime
        rem     $t5, $t5, 10    # move remainder to $t5
        div     $t2, $t5, 5     # div by nickle
        rem     $t5, $t5, 5     # move remainder to $t5
        div     $t3, $t5, 1     # div by penny


outq:
        beqz    $t0, outd       # if qrt == 0, no change
        la      $a0, qtr        # output qtr text
        li      $v0, 4
        syscall
        move    $a0, $t0        # output qtr
        li      $v0, 1
        syscall
outd:
        beqz    $t1, outn       # if dime == 0, no change
        la      $a0, dime       # output dime text
        li      $v0, 4
        syscall
        move    $a0, $t1        # output dime
        li      $v0, 1
        syscall
outn:
        beqz    $t2, outp       # if nickle == 0, no change
        la      $a0, nickle     # output nickle text
        li      $v0, 4
        syscall
        move    $a0, $t2        # output nickle
        li      $v0, 1
        syscall
outp:
        beqz    $t3, exit       # if penny == 0, no change
        la      $a0, penny      # output penny text
        li      $v0, 4
        syscall
        move    $a0, $t3        # output penny
        li      $v0, 1
        syscall
exit:
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        li	$v0, 10         # $v0  10 = exit
        syscall

        .end    main
