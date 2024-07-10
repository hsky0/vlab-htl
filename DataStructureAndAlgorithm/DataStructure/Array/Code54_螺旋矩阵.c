/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {
    int m = matrixSize, n = matrixColSize[0];
    int* res = (int*)calloc(m * n, sizeof(int));
    *returnSize = m * n;

    int num = 0;
    int l = 0, r = n - 1, t = 0, b = m - 1;
    while(num < m * n){
        for(int i = l; i <= r; i++) res[num++] = matrix[t][i];
        t++;
        for(int i = t; i <= b; i++) res[num++] = matrix[i][r];
        r--;
        for(int i = r; i >= l; i--) res[num++] = matrix[b][i];
        b--;
        for(int i = b; i >= t; i--) res[num++] = matrix[i][l];
        l++;

    }

    return res;
}   

int main(){

    int matrix[3][3] = {{1,2,3},{4,5,6},{7,8,9}};
    int returncol[3] = {3, 3, 3};

    int n = 0;
    int* res = spiralOrder(matrix, 3, returncol, &n);

    for(int i = 0; i < n; i++){
        printf("%d ", res[i]);
    } 
    return 0;
}