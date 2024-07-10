#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void removeExtraSpaces(char* s){
    int slow = 0;
    int n = strlen(s);
    for(int i = 0; i < n; i++){
        if(s[i] != ' '){
            if(slow != 0) s[slow++] = ' ';
            while(i < n){
                s[slow++] = s[i++];
            }
        }
    }
    s[slow] = 0;
}

int main(){

    char s[] = "  htk  hgjf hngh";
    printf("%s\n", s);
    removeExtraSpaces(s);
    printf("%s\n", s);

    return 0;
}