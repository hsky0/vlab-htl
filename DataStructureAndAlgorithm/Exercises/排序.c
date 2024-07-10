#include <stdio.h>
#include <stdlib.h>

int cmp(const void* a, const void* b){
    return *((int*)a) > *((int*)b);
}

void printArray(int *num, int len){
    for(int i = 0; i < len; i++){
        printf("%d ", num[i]);
    }
    printf("\n");
}

int main(){


    int a[] = {1, 2, 8, 5, 3};
    printArray(a, 5);
    qsort(a, 5, sizeof(int), cmp);
    printArray(a, 5);
    return 0;
}