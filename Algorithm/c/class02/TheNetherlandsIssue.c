#include <stdio.h>
#include <stdlib.h>
#include "GlobalFuncs.h"


// 给定一个数组arr[L...R]和一个数num
//要求：将数组中小于等于num的数放在数组左边，大于num的数放在右边
int theNetherlandIssue_v1(int *arr, int length, int num){
    int i = 0;
    int leftptr = -1;
    while (i < length)
    {
        if(arr[i] <= num){
            swap(arr, ++leftptr, i++);
        }
        else{
            i++;
        }
    }
    
}

int theNetherlandIssue_v2(int *arr, int length, int num){
    int i = 0;
    int leftptr = -1;
    int rightptr = length;
    while (i < rightptr)
    {
        if(arr[i] < num){
            swap(arr, ++leftptr, i++);
        }
        else if(arr[i] == num){
            i++;
        }
        else{
            swap(arr, --rightptr, i);
        }
    }
    
}

int main(){

    int n = 20;
    int V = 10;
    for(int i =  0; i < 5; i++){
        int *arr = randomArray(n, V);
        printArray(arr, n);
        theNetherlandIssue_v2(arr, n, 5);
        printArray(arr, n);
        printf("\n");
    }

    return 0;
}