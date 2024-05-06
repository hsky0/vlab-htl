#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "define.h"


/*对数器，用于测试排序代码是否输出相同的结果
**传递两个排序函数，测试排序函数是否正确
**N：表示数值的长度
**V：表示数值元素的最大值
**testTimes：表示测试次数
**fixLength：表示测试的数组的长度是否固定，1表示固定，0表示随机，范围为[0~N-1]
*/
void validator(void (*func1)(int *, int), void (*func2)(int *, int), int N, int V, int testTimes, int fixLength){

    struct timeval startTime, stopTime;
    printf("测试开始...\n");
    gettimeofday(&startTime, NULL);
    for(int i = 0; i < testTimes; i++){
        int n = fixLength ? N : (int)((rand() / (RAND_MAX + 1.0)) * N);
        int *arr1 = randomArray(n, V);
        int *arr2 = copyArray(arr1, n);
        //排序
        func1(arr1, n);
        func2(arr2, n);
        //测试
        if(!sameArray(arr1, arr2, n)){
            printf("出现错误！\n");
            free(arr1);
            free(arr2);
            arr1 = NULL, arr2 = NULL;
                break;
        }
        free(arr1);
        free(arr2);
        arr1 = NULL, arr2 = NULL;
    }
    gettimeofday(&stopTime, NULL);
    double timeUse = (stopTime.tv_sec - startTime.tv_sec) + (stopTime.tv_usec - startTime.tv_usec) / 1000000.0;
    printf("测试结束\n");
    printf("timeUse = %fs\n", timeUse);
    
}

/*测试排序算法对某一长度数组排序所用的时间
**func：排序算法
**arr：要排序的数组
*/
void SortTimeTest(void (*func)(int *, int), int *arr, int length){

    struct timeval startTime, stopTime;
    printf("测试开始...\n");
    gettimeofday(&startTime, NULL);
    func(arr, length);
    gettimeofday(&stopTime, NULL);
    double timeUse = (stopTime.tv_sec - startTime.tv_sec) + (stopTime.tv_usec - startTime.tv_usec) / 1000000.0;
    printf("测试结束\n");
    printf("timeUse = %fs\n", timeUse);
}

int Acomp(const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}
/*测试c语言自带排序算法对数组排序所需的时间*/
int testBuildinSort(int *arr, int length){
    struct timeval startTime, stopTime;
    printf("测试开始...\n");
    gettimeofday(&startTime, NULL);
    qsort(arr, length, sizeof(arr[0]), Acomp);
    gettimeofday(&stopTime, NULL);
    double timeUse = (stopTime.tv_sec - startTime.tv_sec) + (stopTime.tv_usec - startTime.tv_usec) / 1000000.0;
    printf("测试结束\n");
    printf("timeUse = %fs\n", timeUse);
}