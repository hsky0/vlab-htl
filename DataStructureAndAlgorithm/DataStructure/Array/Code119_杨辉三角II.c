#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getRow(int rowIndex, int* returnSize) {
    *returnSize = rowIndex + 1;
    int* ret = malloc(sizeof(int) * (rowIndex + 1));
    if(rowIndex == 0){
        ret[0] = 1;
        return ret;
    } else if(rowIndex == 1){
        ret[0] = 1, ret[1] = 1;
        return ret;
    } else{
        ret[0] = 1, ret[1] = 1;
        for(int i = 2; i <= rowIndex; i++){
            int temp1 = ret[0];
            int temp2 = ret[1];
            for(int j = 1; j < i; j++){
                ret[j] = temp1 + temp2;
                if(j + 1 < i){
                    temp1 = temp2;
                    temp2 = ret[j + 1];
                }
                
            }
            ret[i] = 1;
        }
    }    
    
    return ret;
}


/*来自leetCode网友的代码*/
// int* getRow(int rowIndex, int* returnSize) {
//     *returnSize = rowIndex + 1;  
//     int* row = (int*)malloc((*returnSize) * sizeof(int));  
//     if (row == NULL) {  
//         // 内存分配失败  
//         *returnSize = 0;  
//         return NULL;  
//     }  
  
//     // 初始化第一列和最后一列的元素为1  
//     for (int i = 0; i <= rowIndex; i++) {  
//         row[i] = 1;  
//     }  
  
//     // 计算中间列的元素  
//     for (int i = 2; i <= rowIndex; i++) {  
//         for (int j = i - 1; j > 0; j--) {  
//             row[j] = row[j] + row[j - 1];  
//         }  
//     }  
  
//     return row; 
// }


int main(){

    int *num = malloc(sizeof(int));
    int *arr;
    arr = getRow(5, num);

    for(int i = 0; i < *num; i++){
        printf("%d ", *(arr + i));
    }
    printf("\n");

    return 0;
}