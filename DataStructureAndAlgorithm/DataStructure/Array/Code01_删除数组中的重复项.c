/*
给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。

返回 k 。

CodeNum:26
*/

#include <stdio.h>

/*mycode*/
int removeDuplicates(int* nums, int numsSize) {
    int count = 1;
    int i = 0, j = 1;
    while(j < numsSize){
        if(nums[j] == nums[i]){
            j++;
        } else {
            nums[++i] = nums[j];
            count++;
        }
    }

    return count;
}

/*官方解答*/
// int removeDuplicates(int* nums, int numsSize) {

//     if(numsSize == 0){
//         return 0;
//     }

//     int f = 1, s = 1;
//     while(f < numsSize){
//         if(nums[f] != nums[f - 1]){
//             nums[s] = nums[f];
//             s++;
//         } 
//         f++;
//     }

//     return s;;
// }

void printArray(int *arr, int n){
    if(arr == NULL){
        printf("数组不存在");
        return;
    }
    if(n == 0){
        printf("[]");
        return;
    }
    printf("[");
    for(int i = 0; i < n - 1; i++){
        printf("%d, ", arr[i]);
    }
    printf("%d]\n", arr[n - 1]);
    
}

int main(){

    int arr1[] = {0, 1, 1, 2, 2, 3, 4, 4};
    int count = removeDuplicates(arr1, 8);
    printf("%d\n", count);
    printArray(arr1, count);

    return 0;
}