#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int getstrlen(char* s){
    int i = 0;
    while(s[i] != 0){
        i++;
    }
    return i;
}

int main(){
    
    
    char s[] = {0};
    printf("请输入包含数字的字符串：\n");
    scanf("%s",s);
    int n = getstrlen(s);
    int count = 0;
    for(int i = 0; i < n; i++){
        if(s[i] >= '0' && s[i] <= '9'){
            count++;
        }
    }
    n = n + count * 5;
    char* res = (char*)calloc(n + 1, sizeof(char));
    int i = getstrlen(s) - 1, j = n - 1;
    while(i >= 0 && j >= 0){
        if(s[i] >= '0' && s[i] <= '9'){
            res[j--] = 'r';
            res[j--] = 'e';
            res[j--] = 'b';
            res[j--] = 'm';
            res[j--] = 'u';
            res[j--] = 'n';
        } else{
            res[j--] = s[i];
        }
        i--;
   
    }
    printf("==========================\n");
    printf("%s\n", s);
    printf("%s\n", res);

    printf("大傻逼\n");
    free(res);
    res = NULL;
    
    return 0;


}