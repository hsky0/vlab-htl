

/*遇到数字则入栈，遇到算符则从栈中取出两个数字进行运算，并将运算结果压入栈中*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int getVal(char* s){
    int n = strlen(s);
    int sum = 0;
    int sign = s[0];
    int i = sign == '-' ? 1 : 0;
    for(; i < n; i++){
        sum += sum * 10 + s[i] - '0';
    }

    return sign == '-' ? -sum : sum;
}

int cal(int t1, int t2, char ch){
    int res = 0;
    if(ch == '+')
        res =  t1 + t2;
    if(ch == '-')
        res = t1 - t2;
    if(ch == '*')
        res = t1 * t2;
    if(ch == '/')
        res = t1 / t2;
    return res;
}

int evalRPN(char** tokens, int tokensSize) {
    int n = tokensSize;
    int *stack = malloc(sizeof(int) * n);
    int top = 0;
    for(int i = 0; i < n; i++){
        if((tokens[i][0] >= '0' && tokens[i][0] <= '9') || tokens[i][0] == '-'){
            stack[top++] = getVal(tokens[i]);
        } else{
            int temp1 = stack[top - 1];
            int temp2 = stack[top - 2];
            int res = cal(temp1, temp2, tokens[i][0]);
            top = top - 2;
            stack[top++] = res;
        }
    }

    return stack[0];
}

int main(){


    char *str[] = {"fkgjbn", "dgfkb"};
    char *s[] = {"2", "1", "+", "3", "*"};
    for(int i = 0; i < 2; i++){
        printf("%s\n", str[i]);
    }

    int res = evalRPN(s, 5);
    printf("%d\n", res);

    return 0;
}