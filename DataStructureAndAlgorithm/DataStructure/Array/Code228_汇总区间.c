/*
给定一个  无重复元素 的 有序 整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b

"a" ，如果 a == b
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char** summaryRanges(int* nums, int numsSize, int* returnSize){

    char** ret = malloc(sizeof(char*) * numsSize);
    *returnSize = 0;
    int left = 0, right = 0;
    while(right < numsSize){
        left = right;
        right++;
        while(right < numsSize && nums[right] == nums[right - 1] + 1){
            right++;
        }
        char* temp = malloc(sizeof(char) * 25);
        sprintf(temp, "%d", nums[left]);
        if(left < right - 1){
            sprintf(temp + strlen(temp), "->");
            sprintf(temp + strlen(temp), "%d", nums[right - 1]);
        }
        ret[(*returnSize)++] = temp;
    }

    return ret;
}




int main(){

    int nums[] = {0,1,2,4,5,7};
    int* reutrnSize;
    char** result;
    result = summaryRanges(nums, 6, reutrnSize);
    // for(int i = 0; i < *reutrnSize; i++){
    //     printf("%s ", ret[i]);
    // }

    return 0;
}