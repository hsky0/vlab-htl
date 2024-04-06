#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "../include/GlobalFuncs.h"


int maxbits(int *arr, int length){

    int maxVal = INT_MIN, res = 0;
    for(int i = 0; i < length; i++){
        maxVal = arr[i] > maxVal ? arr[i] : maxVal;
    }
    while (maxVal != 0)
    {
        res++;
        maxVal /= 10;
    }
    return res;
}

int getDigit(int value, int d){

    int res = 0;
    while (d > 1)
    {
        value /= 10;
        d--;
    }

    res = value % 10;
    return res;
    
}

void radixSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    radixSort_process(arr, 0, length - 1, maxbits(arr, length));
}

void radixSort_process(int *arr, int L, int R, int digit){

    static int radix = 10;          // 基数，这里设置位10
    int i = 0, j = 0;
    int *bucket = (int *)malloc((R - L + 1) * sizeof(arr[0]));
    for(int d = 1; d <= digit; d++){
        int *count = (int *)malloc(radix * sizeof(int));
        for(i = 0; i < radix; i++){
            count[i] = 0;
        }
        for(i = L; i <= R; i++){        // 入桶，这里即用一个数组记录arr元素的第d位值出现的次数
            j = getDigit(arr[i], d);
            count[j]++;
        }
        for(i = 1; i < radix; i++){
            count[i] += count[i - 1];
        }
        for(i = R; i >= L; i--){
            j = getDigit(arr[i], d);
            bucket[count[j] - 1] = arr[i];
            count[j]--;
        }
        for(i = L, j = 0; i <= R; i++, j++){
            arr[i] = bucket[j];
        }

        free(count);
        count = NULL;
    }
    free(bucket);
    bucket = NULL;
}



int main(){


    int N = 10;
    int V = 1000;
    int testTimes = 100000;
    //validator(selectSort, bubbleSort, N, V, testTimes, 1);
    validator(selectSort, radixSort, N, V, testTimes, 1);

}


