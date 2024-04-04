#ifndef __GLOBALFUNCS_H__
#define __GLOBALFUNCS_H__


int *randomArray(int n, int V);
void printArray(int *arr, int length);
void swap(int *arr, int i, int j);
int sameArray(int *arr1, int *arr2, int length);
int *copyArray(int arr[], int length);
void process(int *arr, int L, int R);
void merge(int *arr, int L, int M, int R);
int *partition(int *arr, int L, int R);
void selectSort(int *arr, int length);
void bubbleSort(int *arr, int length);
void insertSort(int *arr, int length);
void mergeSort(int *arr, int length);
void quickSort(int *arr, int length);
void validator(void (*func1)(int *, int), void (*func2)(int *, int), int N, int V, int testTimes, int fixLength);


#endif