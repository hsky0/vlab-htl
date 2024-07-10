#include <stdio.h>
#include <stdlib.h>


void printArray(int* num, int numSize){
    printf("[");
    for(int i = 0; i < numSize - 1; i++){
        printf("%d, ", num[i]);
    }
    printf("%d]", num[numSize - 1]);
}