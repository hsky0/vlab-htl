#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void removeExtraSpaces(char* s){
    int slow = 0, i = 0;
    int n = strlen(s);
    while(i < n){
        if(s[i] != ' '){
            
            if(slow != 0) s[slow++] = ' ';
            while(i < n && s[i] != ' '){
                s[slow++] = s[i++];
            }
        }
        i++;
    }

    s[slow] = 0;
}

void reverse(char* s, int l, int r){
    while(l < r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        l++; r--;
    }
}

char* reverseWords(char* s) {
    removeExtraSpaces(s);
    reverse(s, 0, strlen(s) - 1);
    int n = strlen(s);
    int start = 0;
    for(int i = 0; i <= n; i++){
        if(s[i] == ' ' || s[i] == 0){
            reverse(s, start, i - 1);
            start = i + 1;
        }
    }

    return s;
}

int main(){

    char s[] = "  this   is a apple";
    // printf("%s\n", s);
    // removeExtraSpaces(s);
    // printf("%s\n", s);

    // char s1[] = "123456789";
    // int n = strlen(s1);
    // reverse(s1, 0, n - 1);
    // printf("%s\n", s1);
    
    printf("%s\n", s);
    reverseWords(s);
    printf("%s\n", s);

    return 0;
}