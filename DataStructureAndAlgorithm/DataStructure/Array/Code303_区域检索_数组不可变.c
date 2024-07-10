/*
给定一个整数数组  nums，处理以下类型的多个查询:

计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int* sums;
} NumArray;


NumArray* numArrayCreate(int* nums, int numsSize){
    NumArray* res = malloc(sizeof(NumArray));
    res->sums = malloc(sizeof(int) * (numsSize + 1));
    res->sums[0] = 0;
    for(int i = 0; i < numsSize; i++){
        res->sums[i + 1] = res->sums[i] + nums[i];
    }
    return res;
}

int numArraySumRange(NumArray* obj, int left, int right){
    return obj->sums[right + 1] - obj->sums[left];
}

void freeNumArray(NumArray* obj){
    free(obj->sums);
}

int main(){

    return 0;
}