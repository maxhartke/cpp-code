# Programming Project 1

This project has 3 separate C programs for you to write. The points for problem 1 is 20,
Problem 2 is 40 and Problem 3 is 40.

1. This project helps you explore some functions from the ctype.h library. It also helps you
master opening,closing and reading from files. You will use functions such as ispunct(),
isalpha() etc. from this library.

Write a C program that can open and read any user provided text file (Ask user for filename).
If you wish, you may read the file line by line or character by character. Then print out the
number of occurrences of each of the vowels a, e, i, o and u in the text, the total number of
consonants, the total number of punctuations and and then print out each of these items as
a % of the total number of characters in the files (ignore blank spaces and any new line
characters). Also output these values into a file called output.txt. Desired output format is as
follows (the numbers in the output below are just being used as an example):

Percentages of various characters:

a 10% ; e 4% ; i 3% ; o 4% ; u 0% ; consonants 67% ; punct 12%

2. This program gets you comfortable with pointers. Write a C program that creates a
structure called matrix. The members of this structure are a float pointer to pointer for
creating a 2D array, and two integers that are the number of rows and columns of this matrix.

struct matrix {
float **m ; // pointer to a pointer for storing the 2D array
int m,n; //m rows and n columns
}

The program should allow the user to enter the size and elements of the two matrices in this
format. e.g. if the size entered by the user is 2x3 (2 rows and 3 columns), the 6 elements can
be entered row wise in a single line like this:

1 4 -5 4 2 0

this is the matrix

1 4 -5</br>
4 2 0

3. This problem gives you further practice with arrays and pointers as well as string
functions from string.h and stdlib.h libraries.
Develop a C program that works with Polynomials. The internal representation of a
polynomial is an array: each element that stores the coefficients and the index of the array
determines the exponents. Have the user enter a string as follows for the polynomial (^
refers to the power of)

-4x^0 + x^1 + 4x^3 - 4x^5 - 3x^7

This polynomial has the second element (exponent 1) of coefficient array store 1. Similarly
the third term is stored as coefficient 4 in the 4

th element (index and exponent 3). The third
element for exponent 2 has a coefficient of 0 since the term doesn't exist. One can figure out
the number of terms in this polynomial by tokenizing the string and looking for substring x^.
Once you know the number of terms, use that to allocate two integer arrays, one that stores
the coefficient and the other stores the exponent. So, for the polynomial above, the
coefficient and exponent arrays will be as follows:

-4 1 0 -4 -3</br>
0 1 3 5 7

The driver program (main part of the program) should ask the user to enter two polynomials
(specify to the user how the polynomial should be entered, use the specified format above)
and then give a choice to do the following:
(1) Addition
(2) Subtraction
(3) Enter two new polynomials
(4) Exit
