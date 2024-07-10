/*给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

说明：虽然被分类为简单题，但感觉比较难，该题有多种解法：暴力遍历、哈希表、排序、分治法、boyer-moore投票
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

/*哈希表实现*/
int majorityElement_hash(int* nums, int numsSize) {
    int maxVal = INT_MIN, minVal = INT_MAX;
    int i = 0;
    while(i < numsSize){
        if(maxVal < nums[i]){
            maxVal = nums[i];
        }
        if(minVal > nums[i]){
            minVal = nums[i];
        }
        i++;
    }

    printf("max = %d, min = %d\n", maxVal, minVal);

    int hashLength = maxVal - minVal + 1;
    int* hash = malloc(sizeof(int) * (hashLength));
    memset(hash, 0, hashLength);
    for(i = 0; i < numsSize; i++){
        hash[nums[i] - minVal]++;
    }
    for(i = 0; i < hashLength; i++){
        if(hash[i] > numsSize / 2){
            printf("i = %d, %d\n", i, hash[i]);
            return i + minVal;
        }
    }

    return 0;
}

int cmp(const void* a, const void* b){

    return *((int*)a) - *((int*)b);
}

int majorityElement_sort(int* nums, int numsSize){

    qsort(nums, numsSize, sizeof(int), cmp);
    return nums[numsSize / 2];
}

int majorityElement_vote(int* nums, int numsSize){
    int candidate = 0;
    int count = 0;
    for(int i = 0; i < numsSize; i++){
        if(candidate == nums[i]){
            count++;
        } else if(count == 0){
            candidate = nums[i];
        } else{
            count--;
        }
    }

    return candidate;

}

int count_in_range(int* nums, int target, int lo, int hi){
    int count = 0;
    for(int i = lo; i <= hi; i++){
        if(nums[i] == target){
            count++;
        }
    }

    return count;
}

int process(int* nums, int lo, int hi){
    if(lo == hi){
        return nums[lo];
    }

    int mid = ((hi - lo) >> 1) + lo;
    int left = process(nums, lo, mid);
    int right = process(nums, mid + 1, hi);
    if(count_in_range(nums, left, lo, hi) > (hi - lo + 1) / 2){
        return left;
    }
    if(count_in_range(nums, right, lo, hi) > (hi - lo + 1) / 2){
        return right;
    }

    return -1;
}

int majorityElement_divide(int* nums, int numsSize){
    return process(nums, 0, numsSize - 1);

}
int main(){

    int nums[] = {3, 2, 3};
    int res = majorityElement_divide(nums, 3);
    printf("res = %d\n", res);

    return 0;
}