#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    char* res = (char*)malloc(sizeof(char) * 20);
    //memset(res, 0, 20);
    res[0] = 'a';
    res[1] = 'b';
    res[2] = 0;
    printf("res = %s\n", res);

    for(int i = 0; i < 10; i++){
        res[i] = (char)(48 + i);
    }
    printf("res = %s\n", res);
    return 0;
}