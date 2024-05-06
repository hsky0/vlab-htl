#include <stdio.h>
#include <stdlib.h>
#include "GlobalFuncs.h"


void heapInsert(int *arr, int index){

    while (arr[index] > arr[(index - 1) / 2])
    {
        swap(arr, index, (index - 1) / 2);
        index = (index - 1) / 2;
    }

}

void heapify(int *arr, int index, int heapSize){

    int left = index * 2 + 1;

    while (left < heapSize)
    {
        int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
        largest = arr[largest] > arr[index] ? largest : index;
        if(largest == index){
            break;
        }
        swap(arr, largest, index);
        index = largest;
        left = index * 2 + 1;
    }
    
    
}


void heapSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }

    // for(int i = 0; i < length; i++){
    //     heapInsert(arr, i);
    // }

    // 从右往左调整，整个循环时间复杂度为O(N)
    for(int i = length - 1; i >= 0; i--){
        heapify(arr, i, length);
    }

    int heapSize = length;
    swap(arr, 0, --heapSize);
    while (heapSize > 0)
    {
        heapify(arr, 0, heapSize);
        swap(arr, 0, --heapSize);
    }
    
}


// int main(){

//     int N = 100;
//     int V = 1000;
//     int testTimes = 1000000;
//     validator(selectSort, heapSort, N, V, testTimes, 1);
// }