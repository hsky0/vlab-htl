#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int main(){


    int a[10] = {0};
    for(int i = 0; i < 10; i++){
        printf("%d ", a[i]);
    }

    int b = (1 << 31);
    printf("a = %d\n", b);

    long c = LONG_MIN;
    printf("c = %ld\n", c);
    return 0;
}