/*
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
如果存在，返回 true ；否则，返回 false 
*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

//哈希表中的元素
struct Node{
    int count;      //记录数组中元素出现的次数
    int distance;   //记录数组中元素重复出现时的距离
};

bool containsNearbyDuplicate_hash(int* nums, int numsSize, int k) {

    if(numsSize <= 1 || k < 1){
        return false;
    }

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
    int hashLength = maxVal - minVal + 1;
    struct Node hash[hashLength];
    
    printf("len = %d, max = %d, min = %d\n", hashLength, maxVal, minVal);
    printf("numsize = %d\n", numsSize);
    for(i = 0; i < hashLength; i++){
        hash[i].count = 0;
        hash[i].distance = 0;    // 初始距离均设置为0
    }
    
    for(i = 0; i < numsSize; i++){
        hash[nums[i] - minVal].count++;
        printf("i = %d, count = %d\n", i, hash[nums[i] - minVal].count);
        if(hash[nums[i] - minVal].count != 1){
            hash[nums[i] - minVal].distance = i - hash[nums[i] - minVal].distance;
            if(hash[nums[i] - minVal].distance <= k){
                return true;
            }
        }
            
    }

    
    return false;
}

/*此版本哈希表函数设置不当，如果数组中元素的最大值与最小值相差很大，则需要为哈希表申请巨大内存，可能会超出内存限制*/
bool containsNearbyDuplicate_sliding_window(int* nums, int numsSize, int k) {
    if(numsSize <= 1 || k < 1){
        return false;
    }

    int maxVal = INT_MIN, minVal = INT_MAX;
    int i = 0;
    while(i < numsSize){
        if(maxVal < nums[i]){
            maxVal = nums[i];
        } 
        if(minVal > nums[i]){
            minVal  = nums[i];
        }
        i++;
    }
    int hashLength = maxVal - minVal + 1;
    int* hash = malloc(sizeof(int) * hashLength);
    printf("length = %d, max = %d, min = %d\n", hashLength, maxVal, minVal);
    for(i = 0; i < hashLength; i++){
        hash[i] = 0;
    }
    int head = 0;           // 滑动窗口的左边界
    for(i = 0; i < numsSize; i++){
        if(i - head <= k){
            hash[nums[i] - minVal]++;
        } else {
            hash[nums[head] - minVal]--;
            hash[nums[i] - minVal]++;
            head++;
        }
        if(hash[nums[i] - minVal] > 1){
            return true;
        }
    }

    return false;
}


/*版本2：重写哈希函数*/
bool containsNearbyDuplicate_sliding_window_v2(int* nums, int numsSize, int k) {
    if(numsSize <= 1 || k < 1){
        return false;
    }
    int i = 0;
    
    int* hash = malloc(sizeof(int) * (k + 1));

    for(i = 0; i < k + 1; i++){
        hash[i] = 0;
    }
    int head = 0;           // 滑动窗口的左边界
    // 哈希函数（有点难想）

    return false;
}

int main(){

    int nums1[] = {1,2,3,1,2,3};
    int nums2[] = {1, 2, 2};
    int nums3[] = {1, 0, 1, 1};
    int nums4[] = {13,23,1,2,3};
    if(containsNearbyDuplicate_hash(nums4, 5, 5)){
        printf("true\n");
    } else {
        printf("false\n");
    }

    return 0;
}