#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    int a[] = {-6, -5, -1, 0, 1, 2};
    for(int i = 0; i < 6; i++){
        printf("%d ", a[i] % 6);
    }
    
    printf("\n");

    int m = fmin(1, 6);
    printf("m = %d\n", m);

    return 0;
}