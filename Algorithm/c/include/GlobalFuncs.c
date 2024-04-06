#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>


// 产生一个随机数组，数组长度为n，数组元素最大值为V
int *randomArray(int n, int V){
    int *arr = (int *)malloc(n * sizeof(int));
    for(int i = 0; i < n; i++){
        arr[i] = (int)((rand() / (RAND_MAX + 1.0)) * V) + 1;
    }

    return arr;
}

// 打印数组
void printArray(int *arr, int length){
    printf("[");
    for(int i = 0; i < length - 1; i++){
        printf("%d, ", arr[i]);
    }
    printf("%d]\n", arr[length - 1]);
}

void swap(int *arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


int sameArray(int *arr1, int *arr2, int length){
    for(int i = 0; i < length; i++){
        if(arr1[i] != arr2[i]){
            return 0;
        }
    }

    return 1;
    
}

int *copyArray(int arr[], int length){

    int *ans = (int *)malloc(sizeof(int) * length);
    for(int i = 0; i < length; i++){
        ans[i] = arr[i];
    }

    return ans;
}


// // 与c语言内部的排序做比较
// void validator(void (*func1)(int *, int), void (*func2)(int *, int), int N, int V, int testTimes, int fixLength){
    
    
    
//     printf("测试开始...\n");
//     struct timeval startTime, stopTime;
//     gettimeofday(&startTime, NULL);
//     for(int i = 0; i < testTimes; i++){
//         int n = fixLength? N : (int)((rand() / (RAND_MAX + 1.0)) * N);
//         int *arr = randomArray(n, V);
//         int *arr1 = copyArray(arr, n);
//         int *arr2 = copyArray(arr, n);
//         func1(arr1, n);
//         func2(arr2, n);
//         if(!sameArray(arr1, arr2, n)){
//             printf("出现错误！");
//             break;
//         }
//     }
//     gettimeofday(&stopTime, NULL);
//     double timeUse = (stopTime.tv_sec - startTime.tv_sec) + (stopTime.tv_usec - startTime.tv_usec) / 1000000.0;
//     printf("测试完成\n");
//     printf("timeUse = %lfs\n", timeUse);
// }

// void selectSort(int *arr, int length){

//     if(length < 2){
//         return;
//     }
//     for(int minIndex, i = 0; i < length; i++){
//         minIndex = i;
//         for(int j = i + 1; j < length; j++){
//             if(arr[j] < arr[minIndex]){
//                 minIndex = j;
//             }
//         }
//         swap(arr, i, minIndex);
//     }
    
// }

// void bubbleSort(int *arr, int length){
//     if(length < 2){
//         return;
//     }
//     for(int end = length - 1; end > 0; end--){
//         for(int i = 0; i < end; i++){
//             if(arr[i] > arr[i + 1]){
//                 swap(arr, i, i + 1);
//             }
//         }
//     }
// }

// void insertSort(int *arr, int length){
//     if(length < 2){
//         return;
//     }
//     for(int i = 1; i < length; i++){
//         for(int j = i; j > 0 && arr[j] < arr[j - 1]; j--){
//             swap(arr, j, j - 1);
//         }
//     }
// }

// void mergeSort(int *arr, int length){
//     process(arr, 0, length - 1);
// }

// void process(int *arr, int L, int R){
//     if(L == R){
//         return;
//     }
//     int mid = L + ((R - L) >> 1);
//     process(arr, L, mid);
//     process(arr, mid + 1, R);
//     merge(arr, L, mid, R);
// }

// void merge(int *arr, int L, int M, int R){

//     int *help = (int *)malloc((R - L + 1) * sizeof(int));
//     int i = 0;
//     int p1 = L;
//     int p2 = M + 1;
//     while (p1 <= M && p2 <= R)
//     {
//         help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//     }
//     while (p1 <= M)
//     {
//         help[i++] = arr[p1++];
//     }
//     while (p2 <= R)
//     {
//         help[i++] = arr[p2++];
//     }
//     for(i = 0; i < (R - L + 1); i++){
//         arr[L + i] = help[i];
//     }
    
//     free(help);
//     help = NULL;
// }
