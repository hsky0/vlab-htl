#include <stdio.h>
#include <stdlib.h>


#define ARRAY_LENGTH 10
#define GET_ARRAY_LENGTH(arr) (sizeof(arr) / sizeof(arr[0]))

void printArray(int arr[], int length);
int *copyArray(int arr[], int length);


int main(){


    int a[ARRAY_LENGTH];

    for(int i = 0; i < ARRAY_LENGTH; i++){
        a[i] = i;
    }

    int *b = copyArray(a, ARRAY_LENGTH);

    printArray(a, ARRAY_LENGTH);
    printArray(b, ARRAY_LENGTH);
    printf("a's length = %ld\n", sizeof(a) / sizeof(int));
    printf("a's length = %ld\n", GET_ARRAY_LENGTH(a));
    printf("b's length = %ld\n", GET_ARRAY_LENGTH(b));

    return 0;
}


void printArray(int arr[], int length){

    int i = 0;
    while (i < length){
        
        printf("%d ", arr[i]);
        i++;
    }
    printf("\n");
    
}

int *copyArray(int arr[], int length){

    int *ans = (int *)malloc(sizeof(int) * length);
    for(int i = 0; i < length; i++){
        ans[i] = arr[i];
    }

    return ans;
}

