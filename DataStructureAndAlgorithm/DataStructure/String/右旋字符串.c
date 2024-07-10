#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void reverse(char* s, int l, int r){
    while(l < r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        l++; r--;
    }
}

char* rightRotateString(char* s, int k){
    if(k < 1){
        return s;
    }
    int n = strlen(s);
    reverse(s, 0, n - 1);

    reverse(s, 0, k - 1);
    reverse(s, k, n - 1);

    return s;
}

int main(){
    
    int k = 3;
    char s[] = "abcdefgh";
    printf("%s\n", s);
    rightRotateString(s, k);
    printf("%s\n", s);
    return 0;
}