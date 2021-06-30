#
#	Name: Hartke, Max
#	Homework: #1
#	Due: 3/1/2021
#	Course: cs-2640-01-sp21
#
#	Description: A Hello World program

	.data
hello: .asciiz "MIPS32 by M. Hartke\n\nhello world!\n"

	.text
main:
	la $a0, hello
	li $v0, 4
	syscall

	li $v0, 10
	syscall
