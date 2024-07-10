/*两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

CodeNum:1
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "uthash.h"

/*迭代实现*/
// int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
//     for(int i = 0; i < numsSize; i++){
//         for(int j = i + 1; j < numsSize; j++){
//             if(nums[i] + nums[j] == target){
//                 int *arr = (int *)(malloc(sizeof(int) * 2));
//                 arr[0] = i;
//                 arr[1] = j;
//                 *returnSize = 2;
//                 return arr;
//             }
//         }
//     }
//     *returnSize = 0;
//     return NULL;
// }

int* randomArray(int n){
    int *arr = (int *)malloc(sizeof(int) * n);
    for(int i = 0; i < n; i++){
        arr[i] = (int)(rand() % 10 + 1);
    }
    return arr;
}

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

// int main(){

//     srand(time(NULL));
//     int n = 5;
//     int *arr = randomArray(n);
//     printArray(arr, n);
    
//     int a[4] = {2, 7, 11, 15};
//     int returnSize;
//     int *res;
//     res = twoSum(a, 4, 9, &returnSize);
//     printArray(res, returnSize);
    
//     int b[0];
//     printArray(b, 0);

//     return 0;
// }


/*使用哈希表实现*/

// struct hashTable{
//     int key;
//     int value;
//     UT_hash_handle hh;
// };

// struct hashTable *hashtable;


// struct hashTable *find(int intkey){
//     struct hashTable *temp;
//     HASH_FIND_INT(hashtable, &intkey, temp);
//     return temp;
// }

// void insert(int intkey, int value){
//     struct hashTable *it = find(intkey);
//     if(it == NULL){
//         struct hashTable *temp = malloc(sizeof(struct hashTable));
//         temp->key = intkey;
//         temp->value = value;
//         HASH_ADD_INT(hashtable, key, temp);
//     }
//     else{
//         it->value = value;
//     }
// }


// int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
//     hashtable = NULL;
//     for(int i = 0; i < numsSize; i++){
//         struct hashTable *it = find(target - nums[i]);
//         if(it != NULL){
//             int *res = malloc(sizeof(int) * 2);
//             res[0] = it->value, res[1] = i;
//             *returnSize = 2;
//             return res;
//         }
//         else{
//             insert(nums[i], i);
//         }
//     }

//     *returnSize = 0;
//     return NULL;

// }


/*Repeat 1 : 哈希表实现*/
struct hashTable{
    int key;
    int value;
    UT_hash_handle hh;
};

struct hashTable *hashtable;

struct hashTable *find(int key){
    struct hashTable *temp;
    HASH_FIND_INT(hashtable, &key, temp);
    return temp;
}

void insert(int key, int value){
    struct hashTable *temp = find(key);
    if(temp == NULL){
        struct hashTable *res = malloc(sizeof(struct hashTable));
        res->key = key, res->value = value;
        HASH_ADD_INT(hashtable, key, res);
    } else {
        temp->value = value;
    }
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    
    hashtable = NULL;
    for(int i = 0; i < numsSize; i++){
        struct hashTable *it = find(target - nums[i]);
        if(it != NULL){
            int *res = malloc(sizeof(int) * 2);
            res[0] = it->value, res[1] = i;
            *returnSize = 2;
            return res;
        } else{
            insert(nums[i], i);
        }
    }
    *returnSize = 0;
    return NULL;
}

int main(){


    int a[4] = {2, 11, 15, 7};
    int returnSize;
    int *res;
    res = twoSum(a, 4, 9, &returnSize);
    printArray(res, returnSize);
    
    return 0;
}