#include <stdio.h>
#include <stdlib.h>
#include <string.h>



void getNextArray(int* next, char* s){

    int j = 0;
    next[0] = 0;
    int n = strlen(s);
    for(int i = 1; i < n; i++){
        while(j > 0 && s[i] != s[j]){
            j = next[j - 1];            // j > 0 保证数组不越界
        }
        if(s[i] == s[j]){
            j++;
        }
        next[i] = j;
    }
}

int main(){

    char s[] = "aabaac";
    int n = strlen(s);
    int* next = (int*)calloc(n, sizeof(int));
    printf("%s\n", s);
    getNextArray(next, s);
    for(int i = 0; i < n; i++){
        printf("%d ", next[i]);
    }

    return 0;
}