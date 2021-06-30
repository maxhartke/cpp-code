#include <stdio.h>

int main()
{
	int x,y,z;
	printf("Please enter 3 numbers\n");
	scanf("%d %d %d", &x, &y, &z);
	printf("sum is %d, average is %d, Product is %d\n", x+y+z, (x+y+z)/3, x*y*z);
	return 0;
	}

