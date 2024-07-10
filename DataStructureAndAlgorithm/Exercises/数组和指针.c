#include <stdio.h>
#include <stdlib.h>



int main(){


    int a[] = {0, 1, 2};
    int* p = a;
    printf("a's address = %d\n", a);\
    printf("p = %d\n", p);

    char c[10];
    c[0] = 'h';
    c[1] = 't';
    c[2] = 'l';
    printf("%s\n", c);
    return 0;
}