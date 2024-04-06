#ifndef __DEFINE_H__
#define __DEFINE_H__

// "include/GlobalFuncs.c"
int *randomArray(int n, int V);
void printArray(int *arr, int length);
void swap(int *arr, int i, int j);
int sameArray(int *arr1, int *arr2, int length);
int *copyArray(int arr[], int length);


// include/Validator.c
void validator(void (*func1)(int *, int), void (*func2)(int *, int), int N, int V, int testTimes, int fixLength);
void SortTimeTest(void (*func)(int *, int), int *arr, int length);
int testBuildinSort(int *arr, int length);

// include/SortFuncs.c
void selectSort(int *arr, int length);
void bubbleSort(int *arr, int length);
void insertSort(int *arr, int length);
void mergeSortProcess(int *arr, int L, int R);
void merge(int *arr, int L, int M, int R);
void mergeSort(int *arr, int length);
void quickSortProcess(int *arr, int L, int R);
int *partition(int *arr, int L, int R);
void quickSort(int *arr, int length);
void heapInsert(int *arr, int index);
void heapify(int *arr, int index, int heapSize);
void heapSort(int *arr, int length);

int maxbits(int *arr, int length);
int getDigit(int value, int d);
void radixSortProcess(int *arr, int L, int R, int digit);
void radixSort(int *arr, int length);




#endif