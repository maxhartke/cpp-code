#
#   Name: Hartke, Max
#   Project: #5
#   Due: May 14, 2021
#   Course: cs-2640-01-sp21
#
#   Description:
#               Program that prompts the user for the coefficients a, b, and c of a quadratic equation 
#               ax^2 + bx + c = 0 and outputs the solutions as shown. discriminant = b^2 – 4ac
#
        .data
title:  .asciiz "Quadratic Equation Solver by M. Hartke\n\n"
pa:     .asciiz "Enter values for a? "
pb:     .asciiz "Enter values for b? "
pc:     .asciiz "Enter values for c? "
notq:   .asciiz "Not a quadratic equation."
img:    .asciiz "Roots are imaginary."
x:      .asciiz "x = "
x1:     .asciiz "x1 = "
x2:     .asciiz "x2 = "

        .text

main:
        la	$a0, title      # display title
        li  	$v0, 4
        syscall
        la	$a0, pa         # display pa
        li  	$v0, 4
        syscall
        li      $v0, 6          # read in a
        syscall
        mov.s   $f12, $f0
        la	$a0, pb         # display pb
        li  	$v0, 4
        syscall
        li      $v0, 6          # read in b
        syscall
        mov.s   $f13, $f0
        la	$a0, pc         # display pc
        li  	$v0, 4
        syscall
        li      $v0, 6          # read in c
        syscall
        mov.s   $f14, $f0
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        jal     solveqe
        beqz    $v0, out0
        beq     $v0, 1, out1
        beq     $v0, 2, out2
        beq     $v0, -1, outimg
out0:
        la	$a0, notq       # display notq
        li  	$v0, 4
        syscall
        jal     exit 
out1:
        la	$a0, x          # display x
        li  	$v0, 4
        syscall
        mov.s   $f12, $f0
        li      $v0, 2
        syscall
        jal     exit
out2:
        la	$a0, x1         # display x1
        li  	$v0, 4
        syscall
        mov.s   $f12, $f0       
        li      $v0, 2
        syscall
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        la	$a0, x2         # display x2
        li  	$v0, 4
        syscall
        mov.s   $f12, $f1
        li      $v0, 2
        syscall
        jal     exit
outimg:
        la	$a0, img        # display img
        li  	$v0, 4
        syscall
        jal     exit 
exit: 
        li      $a0, '\n'       # new line
        li      $v0, 11
        syscall
        li      $v0, 10         # exit
        syscall
        .end    main  
#
#       int solveqe(float a, float b, float c)
#               solve for solutions
#       Parameters:
#               f12: a
#               f13: b
#               f14: c
#       Return value:
#               v0: status
#                       -1: imaginary,
#                       0: not quadratic,
#                       1: 1 solution, x in f0,
#                       2: 2 solutions, x1, x2 in f0, f1.
#
solveqe:
        addiu   $sp, $sp, -8    # allocate space on the stack
        sw      $ra, ($sp)      # store return address in allocated space
        li.s    $f4, 0.0        # check if a = 0
        c.eq.s  $f12, $f4
        bc1t    a0              # if a = 0 then a0
        mul.s   $f4, $f13, $f13 # f4: d = b^2
        li.s    $f5, 4.0        # load in 4
        mov.s   $f9, $f12       # store a in f9
        mul.s   $f12, $f12, $f14# multiply a * c
        mul.s   $f12, $f12, $f5 # multiply by 4
        sub.s   $f4, $f4, $f12  # d - 4ac
        li.s    $f6, 0.0        # load in 0
        c.lt.s  $f4, $f6        # check if d < 0
        bc1t    rimg            # if d < 0 then rimg
        mov.s   $f12, $f4       # move d into f12
        jal     sqrt            # call sqrt
        mov.s   $f6, $f0        # move sqrt into f6
        li.s    $f7, -1.0       # load in -1
        mul.s   $f13, $f13, $f7 # get negative b
        add.s   $f0, $f13, $f6  # -b + sqrt of d
        li.s    $f8, 2.0        # load in 2
        mul.s   $f9, $f9, $f8,  # multiply a by 2
        div.s   $f0, $f0, $f9   # divide by 2a
        sub.s   $f1, $f13, $f6  # -b - sqrt of d
        div.s   $f1, $f1, $f9   # divide by 2a
        li      $t0, 2          # return 2 
        move    $v0, $t0                  
        jal     return
a0:
        li.s    $f4, 0.0        # load in 0
        c.eq.s  $f13, $f4       # check if b = 0
        bc1t    b0              # if b = 0 then b0
        li.s    $f4, -1.0       # load in -0
        mul.s   $f14, $f14, $f4 # get negative c
        div.s   $f0, $f14, $f13 # else x = -c/b
        li      $t0, 1          # return 1 
        move    $v0, $t0                  
        jal     return
b0:     
        li      $t0, 0          # return 0 
        move    $v0, $t0                  
        jal     return
rimg:    
        li      $t0, -1         # return -1 
        move    $v0, $t0                  
        jal     return
return:        
        lw      $ra, ($sp)      # return to main
        addiu   $sp, $sp, 8 
        jr      $ra
#
#       float sqrt(float x)
#               return the square root of x
#       Parameters:
#               f12: x
#       Return value:
#               f0: square root of x
#
sqrt:
        sqrt.s  $f0, $f12       # compute square root of x
        jr      $ra             # return to solveqe