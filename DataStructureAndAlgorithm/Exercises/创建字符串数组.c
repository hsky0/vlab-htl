#include <stdio.h>
#include <stdlib.h>

void upper(char *c){
    if(*c >= 97){
        *c = (*c) - 32;
    }
}


char* intTostr(int num){
    char temp[10] = {0};
    char *str = (char*)malloc(sizeof(char) * 10);
    for(int i = 0; i < 10; i++){
        str[i] = 0;
    }
    int i = 0, j = 0;
    while(num){
        temp[i] = (char)(num % 10 + 48);
        num = num / 10;
        i++;
        
    }
    printf("%s\n", temp);
    i--;
    for(i ; i >= 0; i--){
        str[j++] = temp[i];
    }
    //str[j] = 0;
    return str;
}

int main(){

    char chs[] = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 
    0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
    char c = 0;
    c = 'H';
    upper(&c);
    printf("%d, chs[c - 'A'] = %d\n", c - 'A', chs[c - 'A']);

    int num = 2;
    char c1 = (char)(num + 48);
    printf("%c\n", c1);
    int num2 = 123;
    intTostr(num2);

    char str1[10];
    int i = 12;
    sprintf(str1, "%d", i + 1);
    printf("%s", str1);
    return 0;
}