#include <stdio.h>
#include <ctype.h>
// program that prompts user for a filename that contains chars
// and prints out the number of vowels, consonants, puncutation
// and the respective percentages
int main(int argc, char **argv)
{
    char str[100];
    char ch;
    float sum = 0, a = 0, e = 0, i = 0, o = 0, u = 0, c = 0, p = 0;
    printf("Please enter a file name\n");
    scanf("%s", str);
    printf("%s\n", str); // display input
    FILE *fp;
    fp = fopen(str, "r");
    while ((ch = fgetc(fp)) != EOF)
    {
        if (ispunct(ch) != 0)
        {
            p++;
        }
        if (isalpha(ch) != 0)
        {
            ch = tolower(ch);
            if (ch == 'a')
            {
                a++;
            }
            else if (ch == 'e')
            {
                e++;
            }
            else if (ch == 'i')
            {
                i++;
            }
            else if (ch == 'o')
            {
                o++;
            }
            else if (ch == 'u')
            {
                u++;
            }
            else
            {
                c++;
            }
        }
    }
    sum = a + e + i + o + u + c + p;
    fclose(fp);
    printf("a: %.0f; e: %.0f; i %.0f; o: %.0f, u: %.0f; consonants: %.0f; punt: %.0f; sum: %.0f\n", a, e, i, o, u, c, p, sum);
    printf("a %.0f%%; e %.0f%%; i %.0f%%; o %.0f%%; u %.0f%%; consonants %.0f%%; punct %.0f%% \n", a / sum * 100, e / sum * 100, i / sum * 100, o / sum * 100, u / sum * 100, c / sum * 100, p / sum * 100);
}