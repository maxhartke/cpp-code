#include <stdio.h>
#include <stdlib.h>

/* Write a C program that prints all perfect numbers between 1 and 1000. 
A perfect number is defined as one whose factors(other than itself) add 
up to the number itself.e.g.factors of 6(other than itself)are 1, 2 and 3. 
Sum of factors is also 6;
6 = 1 + 2 + 3.

    Similarly,
    the next perfect number is 28 because factors are 1, 2, 4, 7 and 15 and 28 = 1 + 2 + 4 + 7 + 14
 */

int main(int argc, char **argv)
{
    int sum = 0, c = 1;
    for (int i = 1; i <= 1000; i++)
    {
        c = i - 1;
        for (int j = 1; j < i; j++)
        {
            while (c > 1)
            {
                if (c * j == i)
                {
                    sum = sum + j;
                }
                c--;
            }
            c = i - j;
        }
        if (sum == i)
        {
            printf("%d ", i);
        }
    }
}
