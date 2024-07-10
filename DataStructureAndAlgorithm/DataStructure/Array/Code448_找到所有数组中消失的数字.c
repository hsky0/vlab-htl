#include <stdio.h>
#include <stdlib.h>

int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize){
    for(int i = 0; i < numsSize; i++){
        int x = (nums[i] - 1) % numsSize;
        nums[x] += numsSize;
    }
    int* ret = malloc(sizeof(int) * numsSize);
    *returnSize = 0;
    for(int i = 0; i < numsSize; i++){
        if(nums[i] <= numsSize){
            ret[(*returnSize)++] = i + 1;
        }
    }
    return ret;
}

int main(){

    int a[] = {1, 5, 2, 2, 3, 1, 1};
    int length;
    int *res = findDisappearedNumbers(a, 7, &length);
    for(int i = 0; i < length; i++){
        printf("%d ", res[i]);
    }

    return 0;
}