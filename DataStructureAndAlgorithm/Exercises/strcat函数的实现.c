#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/*strcat(k, s)，在字符串k的结尾加上字符串s的内容*/

int mystrcat(char* dest, char* src){

    int n = strlen(src);
    int i = 0, j = 0;
    while(dest[i] != 0){
        i++;
    }
    while(j < n){
        dest[i++] = src[j++];
    }
    dest[i] = 0;
}

int main(){

    char s[] = "htlvgbhln";
    int n = strlen(s);
    char k[n * 2 + 1];
    k[0] = 0;
    mystrcat(k, s);
    mystrcat(k, s);
    mystrcat(k, s);
    printf("%s\n", s);
    printf("%s\n", k);
    printf("k size = %ld\n", strlen(k));
    return 0;
}