#include <stdio.h>
#include <stdlib.h>

/*
**产生一个随机数组
**数组长度为n
**数组元素最大值为V
*/
int *randomArray(int n, int V){
    int *arr = (int *)malloc(n * sizeof(int));
    for(int i = 0; i < n; i++){
        arr[i] = (int)((rand() / (RAND_MAX + 1.0)) * V + 1);
    }

    return arr;
}

/*打印数组*/
void printArray(int *arr, int length){

    printf("[");
    for(int i = 0; i < length; i++){
        printf("%d ", arr[i]);
    }
    printf("]\n");
}