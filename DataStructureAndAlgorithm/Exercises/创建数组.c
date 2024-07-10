#include <stdio.h>
#include <stdlib.h>

struct Node{
    int count;      //记录数组中元素出现的次数
    int distance;   //记录数组中元素重复出现时的距离
};

// int main(){

//     int n = 10;
//     int a[n];
//     for(int i = 0; i < n; i++){
//         a[i] = i + 1;
//     } 

//     for(int i = 0; i < n; i++){
//         printf("%d ", a[i]);
//     }
//     printf("\n");

//     struct Node hash[n];
//     for(int i = 0; i < n; i++){
//         hash[i].count = 0;
//         hash[i].distance = 0;    // 初始距离均设置为0
//     }

//     for(int i = 0; i < n; i++){
//         printf("count = %d, distance = %d\n", hash[i].count, hash[i].distance);
//     }

//     return 0;
// }

void createArray(int n){
    int a[] = {0};
    for(int i = 0; i < n; i++){
        a[i] = i + 1;
    }
    for(int i = 0; i < n; i++){
        printf("%d ", a[i]);
    }
}


int main(){

    int a[] = {0};
    int b[1] = {0};
    int c[2] = {0};
    printf("a size = %d\n", sizeof(a));
    printf("b size = %d\n", sizeof(b));
    printf("c size = %d\n", sizeof(c));

}