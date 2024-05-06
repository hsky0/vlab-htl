#include <stdio.h>


int test(int *x){

    *x = 1024;
    printf("test x = %d\n", *x);
}


int main(){


    int x = 2024;
    printf("main x = %d\n", x);
    test(&x);
    printf("called test in main x = %d\n", x);

    return 0;
}