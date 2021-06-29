#include <stdio.h>
#include <time.h>
#include <stdlib.h>

struct matrix
{
    float **M; // pointer to a pointer for storing the 2D array
    int m, n;  // m rows and n columns
};

struct matrix multiply(struct matrix matrix1, struct matrix matrix2)
{
    for (int i = 0; i < matrix1.m; i++)
    {
        for (int j = 0; j < matrix1.n; j++)
        {
            int el1 = *(*(matrix1.M + i) + j);
            int el2 = *(*(matrix2.M + i) + j);
            *(*(matrix1.M + i) + j) = el1 * el2;
        }
    }
    return matrix1;
};

int main(int argc, char **argv)
{
    struct matrix matrix1;
    struct matrix matrix2;
    struct matrix result;

    printf("Please enter the rows and columns of the first matrix\n");
    scanf("%d %d", &matrix1.m, &matrix1.n);
    printf("%dx%d\n", matrix1.m, matrix1.n); // display input
    matrix1.M = (float **)malloc(matrix1.n * sizeof(int *));
    for (int i = 0; i < matrix1.m; i++)
    {
        *(matrix1.M + i) = (float *)malloc(matrix1.n * sizeof(int));
    }
    printf("Please enter the elemenets of first matrix\n");
    for (int i = 0; i < matrix1.m; i++)
    {
        for (int j = 0; j < matrix1.n; j++)
        {
            int tmp;
            scanf("%d", &tmp);
            *(*(matrix1.M + i) + j) = tmp;
            printf("%.0f ", *(*(matrix1.M + i) + j)); // display input
        }
    }
    printf("\n"); // display input
    printf("Please enter the rows and columns of the second matrix\n");
    scanf("%d %d", &matrix2.m, &matrix2.n);
    printf("%dx%d\n", matrix2.m, matrix2.n); // display input
    matrix2.M = (float **)malloc(matrix2.n * sizeof(int *));
    for (int i = 0; i < matrix2.m; i++)
    {
        *(matrix2.M + i) = (float *)malloc(matrix2.n * sizeof(int));
    }
    printf("Please enter the elemenets of second matrix\n");
    for (int i = 0; i < matrix2.m; i++)
    {
        for (int j = 0; j < matrix2.n; j++)
        {
            int tmp;
            scanf("%d", &tmp);
            *(*(matrix2.M + i) + j) = tmp;
            printf("%.0f ", *(*(matrix2.M + i) + j)); // display input
        }
    }
    printf("\n"); // display input
    if (matrix1.m != matrix2.m && matrix1.n != matrix2.n)
    {
        printf("Matrices are unable to be multiplied\n");
        exit(1);
    }
    result = multiply(matrix1, matrix2);
    printf("Multiplied Matrix\n");
    for (int i = 0; i < result.m; i++)
    {
        for (int j = 0; j < result.n; j++)
        {
            printf("%.0f ", *(*(result.M + i) + j));
        }
        printf("\n");
    }
}
