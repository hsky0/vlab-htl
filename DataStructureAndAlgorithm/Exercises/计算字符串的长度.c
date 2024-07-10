#include <stdio.h>
#include <stdlib.h>

int stringlen(char* str){
    int i = 0;
    while(str[i] != 0){
        i++;
    }

    return i;
}

int main(){

    char s[] = "fgghib0";
    int len = stringlen(s);
    printf("len = %d\n", len);
    s[2] = 0;
    printf("len = %d\n", stringlen(s));
    return 0;
}