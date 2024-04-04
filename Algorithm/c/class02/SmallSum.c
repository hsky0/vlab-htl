#include <stdio.h>
#include <stdlib.h>
#include "GlobalFuncs.h"

int smallSum(int *arr, int length){
    if(arr == NULL || length < 2){
        return 0;
    }
    return process(arr, 0, length - 1);
}

int process(int *arr, int L, int R){
    if(L == R){
        return 0;
    }
    int mid = L + ((R - L) >> 1);
    return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
}

int merge(int *arr, int L, int M, int R){
    int *help = (int *)malloc((R - L + 1) * sizeof(arr[0]));
    int i = 0;
    int p1 = L;
    int p2 = M + 1;
    int res = 0;
    while (p1 <= M && p2 <= R)
    {
        res += arr[p1] < arr[p2] ? ((R - p2 + 1) * arr[p1]) : 0;
        help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
    }
    while (p1 <= M)
    {
        help[i++] = arr[p1++];
    }
    while (p2 <= R)
    {
        help[i++] = arr[p2++];
    }
    for(i = 0; i < (R - L + 1); i++){
        arr[i + L] = help[i];
    }

    return res;
    
    
}

int main(){

    int n = 5;
    int V = 5;
    for(int i =  0; i < 3; i++){
        int *arr = randomArray(n, V);
        printArray(arr, n);
        int res = smallSum(arr, n);
        printf("%d\n", res);
    }
    

    return 0;
}