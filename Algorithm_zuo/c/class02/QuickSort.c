#include <stdio.h>
#include <stdlib.h>
#include "GlobalFuncs.h"


void quickSort(int *arr, int length){

    if(arr == NULL || length < 2){
        return;
    }
    process(arr, 0, length - 1);
}

// void process(int *arr, int L, int R){
//     if(L < R){
//         swap(arr, L + (int)((rand() / (RAND_MAX + 1.0)) * (R -L + 1)), R);
//         int *p = partition(arr, L, R);
//         process(arr, L, p[0] - 1);
//         process(arr, p[1] + 1, R);
//     }

// }

int *partition(int *arr, int L, int R){
    int less = L - 1;
    int more = R;
    while (L < more)        // L为当前数的下标
    {
        if(arr[L] < arr[R]){
            swap(arr, ++less, L++);
        }
        else if(arr[L] == arr[R]){
            L++;
        }
        else{
            swap(arr, --more, L);
        }
    }
    swap(arr, more, R);
    int *p = (int *)malloc(2 * sizeof(int));
    p[0] = less + 1;
    p[1] = more;
    return p;
}


// int main(){
                
//     int N = 100;
//     int V = 1000;
//     int testTimes = 1000000;
//     validator(selectSort, quickSort, N, V, testTimes, 1);
//     validator(bubbleSort, quickSort, N, V, testTimes, 1);
//     validator(insertSort, quickSort, N, V, testTimes, 1);
//     validator(mergeSort,  quickSort, N, V, testTimes, 1);
    

//     return 0;
// }

