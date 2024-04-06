#include <stdio.h>
#include <stdlib.h>
#include "define.h"




int main(){

    int n = 30;
    int v = 10;
    // int N = 100000;
    // int V = 1000;
    int testTimes = 10000;
    // int *arr = randomArray(n, v);
    // printArray(arr, n);
    // int *arr1 =copyArray(arr, n);
    // selectSort(arr1, n);
    // printArray(arr1, n);
    // int *arr2 =copyArray(arr, n);
    // bubbleSort(arr2, n);
    // printArray(arr2, n);
    // int *arr3 =copyArray(arr, n);
    // insertSort(arr3, n);
    // printArray(arr3, n);
    // int *arr4 =copyArray(arr, n);
    // mergeSort(arr4, n);
    // printArray(arr4, n);
    // int *arr5 =copyArray(arr, n);
    // quickSort(arr5, n);
    // printArray(arr5, n);
    // int *arr6 =copyArray(arr, n);
    // heapSort(arr6, n);
    // printArray(arr6, n);
    // int *arr7 =copyArray(arr, n);
    // radixSort(arr7, n);
    // printArray(arr7, n);


    // validator(selectSort, bubbleSort, N, V, testTimes, 1);
    // validator(selectSort, insertSort, N, V, testTimes, 1);
    // validator(selectSort, mergeSort,  N, V, testTimes, 1);
    // validator(selectSort, quickSort,  N, V, testTimes, 1);
    // validator(selectSort, heapSort,   N, V, testTimes, 1);
    // validator(selectSort, radixSort,  N, V, testTimes, 1);

    int N = 10000;
    int V = 1000;
    int *testArray = randomArray(N, V);

    testBuildinSort(testArray, N);
    SortTimeTest(selectSort, testArray, N);
    SortTimeTest(bubbleSort, testArray, N);
    SortTimeTest(insertSort, testArray, N);
    SortTimeTest(mergeSort,  testArray, N);
    SortTimeTest(quickSort, testArray, N);
    SortTimeTest(heapSort,   testArray, N);
    SortTimeTest(radixSort,  testArray, N);


    return 0;
}

