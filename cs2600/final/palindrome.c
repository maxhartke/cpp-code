/* Write a C program that reads in a string from the user and figures out if it is a palindrome or not. 
Dynamically allocate memory of size 100 to a character pointer. 
The string entered by the user will only have lower case alphabets and no other characters other than 
lower case alphabets. A palindrome is defined as a string read from the beginning or the end as being 
the same. e.g. the word madam is a palindrome as it is the same word if read from front to back or 
back to front. Another example is the string:

a man a plan a canal panama

If you ignore blank spaces in the string above, it will be a palindrome.

Your program should read the string and compare first character to the last and if they are the same, 
then moves on to the next two characters (second with second last character) and so on. 
If you encounter a blank space, skip it and move on to the next character. 
In the end, your program prints out if the given string is a palindrome or not.  
Please make sure that you are not using the array notation with square brackets [] at any point in your 
program but using the pointer notation instead using * for dereferencing. */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(int argc, char **argv)
{
    char *str = (char *)malloc(100);
    printf("Please enter a string\n");
    scanf("%[^\n]%*c", str);
    int l = strlen(str) - 1;
    int i = 0;
    while (*(str + i) == *(str + l))
    {
        if (i == l)
        {
            printf("%s is a palindrome\n", str);
            exit(1);
        }
        i++;
        l--;
    }
    printf("%s is not a palindrome\n", str);
    return 0;
}