#include <stdio.h>
#include <string.h>


void print2DArray(int (*a)[2], int row, int col){
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){

            printf("%d ", a[i][j]);
        }
        printf("\n");
    }

    printf("\n");
}

int main(){


    int a[2][2] = {{1, 2}, {3, 4}};

    print2DArray(a, 2, 2);


    return 0;
}