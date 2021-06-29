#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *add(int co1[], int ex1[], int co2[], int ex2[], int l)
{
    int *result = (int *)malloc(l * sizeof(int));
    for (int i = 0; i < l; i++)
    {
        result[i] = *(co1 + i) + *(co2 + i);
    }

    return result;
};

int *sub(int co1[], int ex1[], int co2[], int ex2[], int l)
{
    int *result = (int *)malloc(l * sizeof(int));
    for (int i = 0; i < l; i++)
    {
        result[i] = *(co1 + i) - *(co2 + i);
    }

    return result;
};

int main(int argc, char **argv)
{
    int option;
    int co;
start:
    printf("please enter the numer of coefficients\n");
    scanf("%d", &co);
    printf("%d\n", co); // display input
    int *co1 = (int *)malloc(co * sizeof(int));
    printf("Please enter the coefficients for the first polynomial\n");
    for (int i = 0; i < co; i++)
    {
        scanf("%d ", co1 + i);
        printf("%d ", *(co1 + i)); // display input
    }
    printf("\n");
    int *ex1 = (int *)malloc(co * sizeof(int));
    printf("Please enter the exponents for the first polynomial\n");
    for (int i = 0; i < co; i++)
    {
        scanf("%d ", ex1 + i);
        printf("%d ", *(ex1 + i)); // display input
    }
    printf("\n");
    int *co2 = (int *)malloc(co * sizeof(int));
    printf("Please enter the coefficients for the second polynomial\n");
    for (int i = 0; i < co; i++)
    {
        scanf("%d ", co2 + i);
        printf("%d ", *(co2 + i)); // display input
    }
    printf("\n");
    int *ex2 = (int *)malloc(co * sizeof(int));
    printf("Please enter the exponents for the second polynomial\n");
    for (int i = 0; i < co; i++)
    {
        scanf("%d ", ex2 + i);
        printf("%d ", *(ex2 + i)); // display input
    }
    printf("\n");
    printf("Please specify what you would like to do\n (1) Addition\n (2) Subtraction\n (3) Enter two new polynomials\n (4) Exit\n");
    scanf("%d", &option);
    printf("\n");
    if (option == 1)
    {
        printf(" (1) Addition\n");
        int counter = 0;
        int *result = add(co1, ex1, co2, ex2, co);
        while (counter < co)
        {
            printf(" %d", *(result + counter));
            counter++;
        }
        printf("\n");
        counter = 0;
        while (counter < co)
        {
            printf(" %d", *(ex2 + counter));
            counter++;
        }
        printf("\n");
        goto start;
    }
    if (option == 2)
    {
        printf(" (2) Subtraction\n");
        int counter = 0;
        int *result = sub(co1, ex1, co2, ex2, co);
        while (counter < co)
        {
            printf(" %d", *(result + counter));
            counter++;
        }
        printf("\n");
        counter = 0;
        while (counter < co)
        {
            printf(" %d", *(ex2 + counter));
            counter++;
        }
        printf("\n");
        goto start;
    }
    if (option == 3)
    {
        printf(" (3) Enter two new polynomials \n");
        goto start;
    }
    if (option == 4)
        printf(" (4) Exit \n");
    {
        exit(1);
    }
}
