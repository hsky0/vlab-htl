#include <stdio.h>
#include <string.h>
#include <stdlib.h>



char* removeDuplicates(char* s) {
    int n = strlen(s);
    char *stack = malloc(sizeof(char) * (n + 1));
    int top = 0;
    for(int i = 0; i < n; i++){
        stack[top++] = s[i];
        if(top >= 2 && stack[top - 2] == stack[top - 1]){
            top = top - 2;
        }
        
    }

    stack[top] = 0;
    return stack;
}


int main(){
    
    char s[] = "abbaca";
    printf("%s\n", s);
    char *res = removeDuplicates(s);
    printf("%s\n", res);


    return 0;
}