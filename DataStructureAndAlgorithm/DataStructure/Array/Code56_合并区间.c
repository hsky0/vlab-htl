/*
以数组 intervals 表示若干个区间的集合，
其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，
该数组需恰好覆盖输入中的所有区间 。
*/

#include <stdio.h>
#include <stdlib.h>


void printArray(int* num, int numSize){
    printf("[");
    for(int i = 0; i < numSize - 1; i++){
        printf("%d, ", num[i]);
    }
    printf("%d]", num[numSize - 1]);
}

int cmp(int** a, int** b){
    return a[0][0] > b[0][0];
}

int** merge(int** intervals, int intervalsSize, int* intervalsColSize, int* returnSize, int** returnColumnSizes) {
    int** res = (int**)malloc(sizeof(int*) * intervalsSize);
    *returnColumnSizes = (int*)malloc(sizeof(int) * intervalsSize);
    for(int i = 0; i < intervalsSize; i++){
        res[i] = (int*)malloc(sizeof(int) * 2);
        (*returnColumnSizes)[i] = 2;
    }
    *returnSize = 0;
    qsort(intervals, intervalsSize, sizeof(intervals[0]), cmp);
    int start = intervals[0][0], end = intervals[0][1];
    int i = 1;
    while(i < intervalsSize){
        if(end >= intervals[i][0]){
            end = intervals[i][1];
        } else{
            res[(*returnSize)] = start;
            res[(*returnSize)] = end;
            (*returnSize)++;
            start = intervals[i][0];
            end = intervals[i][1];
            i++;
        }
    }
    res[(*returnSize)] = start;
    res[(*returnSize)] = end;
    (*returnSize)++;

    return res;
}

int main(){

    int a[][2] = {{1, 2}, {5, 6}};
    

    return 0;
}

