/*
指针数组：本质上是数组，只不过数组里面存放的都是地址，指向某一内存
数组指针：本质上是指针，即为数组的指针，可以通过该指针访问数组的元素
*/

#include <stdio.h>



int main(){


    int* ptrArray[5];           // 声明一个指针数组
    int a = 1;
    int b = 2;
    int c = 3;
    int data[] = {0, 1, 2, 3};
    ptrArray[0] = &a;
    ptrArray[1] = &b;
    ptrArray[2] = data;
    ptrArray[3] = &c;
    int value1 = *ptrArray[0];
    int value2 = *ptrArray[1];
    printf("value1 = %d, value2 = %d, c = %d, data[0] = %d\n", value1, value2, *ptrArray[3], ptrArray[2][0]);
    printf("&a = %p, &b = %p, &c = %p, ptrArray[2] = %p\n", ptrArray[0], ptrArray[1], ptrArray[3], ptrArray[2]);
    
    int arr[] = {4, 5, 6};
    int (*ptr)[];
    ptr = &arr;
    for(int i = 0; i < 3; i++){
        printf("%d ", (*ptr)[i]);
    }
    
    
    
    
    return 0;
}