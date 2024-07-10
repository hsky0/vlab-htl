#include <stdio.h>
#include <stdlib.h>
#include <string.h>



int binarySearch(int* nums, int l, int r, int target){
    int left = l, right = r, mid = -1;
    while(left < right){
        mid = ((right - left) >> 1) + left;
        if(nums[mid] < target){
            left = mid + 1;
        } else{
            right = mid;
        }
    }

    return (nums[left] >= target) ? left : -1;
}

int main(){

    int a[] = {0, 1, 2, 4, 4, 5};
    int res = binarySearch(a, 0, 5, 3);

    printf("%d\n", res);

    return 0;
}