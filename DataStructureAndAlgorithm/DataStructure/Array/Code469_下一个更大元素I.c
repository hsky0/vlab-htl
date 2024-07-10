/*
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
*/

#include <stdio.h>
#include <stdlib.h>


/*暴力循环*/
int* nextGreaterElement(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int* ans = (int*)malloc(sizeof(int) * nums1Size);
    *returnSize = 0;
    for(int i = 0; i < nums1Size; i++){
        for(int j = 0; j < nums2Size; j++){
            if(nums1[i] == nums2[j]){
                int temp = -1;
                for(int k = j + 1; k < nums2Size; k++){
                    if(nums2[k] > nums1[i]){
                        temp = nums2[k];
                        break;
                    }
                }
                
                ans[(*returnSize)++] = temp;
            }
        }
    }

    return ans;
}



int main(){

    int a[] = {4, 1, 2};
    int b[] = {1, 3, 4, 2};
    int len;
    int* ans = nextGreaterElement(a, 3, b, 4, &len);
    for(int i = 0; i < len; i++){
        printf("%d ", ans[i]);
    }

    return 0;
}