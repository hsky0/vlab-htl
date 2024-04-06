#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "define.h"

/*选择排序*/
void selectSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    for(int minIndex = 0, i = 0; i < length; i++){
        minIndex = i;
        for(int j = i; j < length; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }
        swap(arr, minIndex, i);
    }
}

/*冒泡排序*/
void bubbleSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    for(int end = length - 1; end > 0; end--){
        for(int i = 1; i <= end; i++){
            if(arr[i] < arr[i - 1]){
                swap(arr, i, i - 1);
            }
        }
    }
}


/*插入排序*/
void insertSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    for(int i = 1; i < length; i++){
        for(int j = i; j > 0; j--){
            if(arr[j] < arr[j - 1]){
                swap(arr, j, j - 1);
            }
        }
    }
}


/*归并排序*/
void mergeSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    mergeSortProcess(arr, 0, length - 1);
}

/*左边和右边分别进行归并*/
void mergeSortProcess(int *arr, int L, int R){
    if(L == R){
        return;         // base case
    }
    int mid = L + ((R - L) >> 1);
    mergeSortProcess(arr, L, mid);           // 左边
    mergeSortProcess(arr, mid + 1, R);       // 右边
    merge(arr, L, mid, R);          // 左右进行合并
}

void merge(int *arr, int L, int M, int R){
    int *help = (int *)malloc((R - L  + 1) * sizeof(arr[L]));
    int i = 0;
    int p1 = L;
    int p2 = M + 1;
    while (p1 <= M && p2 <= R)
    {
        help[i++] = arr[p2] < arr[p1] ? arr[p2++] : arr[p1++];
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
    free(help);
    help = NULL;

}


/*快排*/
void quickSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    quickSortProcess(arr, 0, length - 1);
}

void quickSortProcess(int *arr, int L, int R){
    if(L < R){
        swap(arr, L + (int)((rand() / (RAND_MAX + 1.0)) * (R - L + 1)), R);
        int *p = partition(arr, L, R);                                          // 返回等于区域边界的下标
        quickSortProcess(arr, L, p[0] - 1);
        quickSortProcess(arr, p[1] + 1, R);
    }
}

int *partition(int *arr, int L, int R){

    int leftptr = L - 1;
    int rightptr = R;
    while (L < rightptr)
    {
        if(arr[L] < arr[R]){
            swap(arr, ++leftptr, L++);      // 如果当前数小于比较数arr[R]，当前数与小于区下一个数交换，小于区往右扩，数组索引加一
        }
        else if(arr[L] > arr[R]){
            swap(arr, --rightptr, L);       // 如果当前数大于比较数arr[R]，当前数与大于区前一个数交换，大于区往左扩
        }
        else{
            L++;
        }
    }
    swap(arr, rightptr, R);
    int *p = (int *)malloc(2 * sizeof(int));
    p[0] = leftptr + 1;
    p[1] = rightptr;
    return p;
    
}

/*大根堆，给出一个索引，判断该值与其父谁大，如果该值比其父大，则交换，进行下一次比较*/
void heapInsert(int *arr, int index){
    while (arr[index] > arr[(index - 1) / 2])
    {
        swap(arr, index, (index - 1) / 2);          //(index - 1) / 2 父的索引
        index = (index - 1) / 2;
    }    
}

/*从index位置，往下将树调整成大根堆*/
void heapify(int *arr, int index, int heapSize){
    int left = index * 2 + 1;           //index的左孩子的索引
    while (left < heapSize)
    {   
        // 比较得出左孩子和右孩子谁大，并将有较大值的孩子的索引赋值给largest
        int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
        
        // 比较得出父和孩子谁的值大，将较大值的索引赋值给largest
        largest = arr[index] > arr[largest] ? index : largest;
        if(largest == index){
            break;
        }
        swap(arr, index, largest);
        index = largest;
        left = index * 2 + 1;
    }
    
}


void heapSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }

    // 从右往左将数组调整成大根堆
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

int maxbits(int *arr, int length){
    int maxVal = INT_MIN;
    for(int i = 0; i < length; i++){
        maxVal = arr[i] > maxVal ? arr[i] : maxVal;
    }
    int res = 0;
    while (maxVal != 0)
    {
        res++;
        maxVal = maxVal / 10;
    }
    return res;
}

int getDigit(int val, int d){
    if(d < 1){
        return 0;
    }
    int res = 0;
    while (d > 1)
    {
        val = val / 10;
        d--;
    }
    res = val % 10;
    return res;
}

void radixSortProcess(int *arr, int L, int R, int digit){

    static int radix = 10;
    int i = 0, j = 0;
    int *bucket = (int *)malloc((R - L + 1) * sizeof(int));
    for(int d = 1; d <= digit; d++){
        int *count = (int *)malloc(radix * sizeof(int));
        for(i = 0; i < radix; i++){
            count[i] = 0;
        }
        for(i = L; i <= R; i++){
            j = getDigit(arr[i], d);
            count[j]++;
        }
        for(i = 1; i < radix; i++){
            count[i] += count[i - 1];
        }
        for(i = R; i >= L; i--){        // 入桶
            j = getDigit(arr[i], d);
            bucket[count[j] - 1] = arr[i];
            count[j]--;
            
        }
        for(i = 0; i < R - L + 1; i++){ // 出桶
            arr[i + L] = bucket[i];
        }
        free(count);
        count  = NULL;
    }

    free(bucket);
    bucket = NULL;
}

/*基数排序(桶排序)*/
void radixSort(int *arr, int length){
    if(arr == NULL || length < 2){
        return;
    }
    
    radixSortProcess(arr, 0, length  - 1, maxbits(arr, length));
    
}






