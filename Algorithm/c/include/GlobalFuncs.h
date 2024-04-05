#ifndef __GLOBALFUNCS_H__
#define __GLOBALFUNCS_H__

// "class02/GlobalFuncs.c"
int *randomArray(int n, int V);
void printArray(int *arr, int length);
void swap(int *arr, int i, int j);
int sameArray(int *arr1, int *arr2, int length);
int *copyArray(int arr[], int length);
void selectSort(int *arr, int length);
void bubbleSort(int *arr, int length);
void insertSort(int *arr, int length);
void process(int *arr, int L, int R);
void merge(int *arr, int L, int M, int R);
void mergeSort(int *arr, int length);
void validator(void (*func1)(int *, int), void (*func2)(int *, int), int N, int V, int testTimes, int fixLength);

// "class02/QuickSort.c"
int *partition(int *arr, int L, int R);
void quickSort(int *arr, int length);



// "class02/HeapSort.c"
void heapInsert(int *arr, int index);
void heapify(int *arr, int index, int heapSize);
void heapSort(int *arr, int length);



// "class03/RadixSort.c"
int maxbits(int *arr, int length);
int getDigit(int value, int d);
void radixSort(int *arr, int length);
void radixSort_process(int *arr, int L, int R, int digit);


#endif