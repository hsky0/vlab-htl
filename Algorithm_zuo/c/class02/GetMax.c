#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAX(a, b)(((a) > (b)) ? (a) : (b))

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
        printf("%d, ", arr[i]);
    }
    printf("]\n");
}

// 使用递归方法找到arr[L...R]范围内的最大值
int process(int *arr, int L, int R){
    if(L == R){                 // base case
        return arr[L];
    }

    int mid = L + ((R - L) >> 1);
    int leftMax = process(arr, L, mid);
    int rightMax = process(arr, mid + 1, R);
    return MAX(leftMax, rightMax);
}

// 找到arr[L...R]范围内的最大值
int getMax(int *arr, int length){
    return process(arr, 0, length - 1);
}


// 主函数，cpu将从此处开始执行
int main(){

    int arrayLength = 10;
    int V = 20;
    int *arr = randomArray(arrayLength, V);
    printArray(arr, arrayLength);
    int maxValue = getMax(arr, arrayLength);
    printf("maxValue = %d", maxValue);

    return 0;
}


