#include <stdio.h>
#include <stdlib.h>

/* Write a C program that opens a text file called input.txt and reads 20 integers from this file
into an integer array of size 20. Then print the smallest integer, sum and average (in float format) 
into another file called output.txt. The format of the output should look like 
follows (the values listed are just for example):

The smallest integer is: 2

The sum of integers is: 345

The average of the integers is: 34.56 */

int main(int argc, char **argv)
{
    int array[20];
    int i, min, avg, sum = 0, c = 0;
    FILE *fp;
    fp = fopen("input.txt", "r");
    while (c < 20)
    {
        i = getw(fp);
        if (c == 0)
        {
            min = i;
        }
        if (i < min)
        {
            min = i;
        }
        sum = sum + i;
        array[c] = i;
        c++;
    }
    avg = sum / 20;
    printf("The smallest integer is : %d\n", min);
    printf("The sum of integers is : %d\n", sum);
    printf("The average of the integers is : %d\n", avg);
}