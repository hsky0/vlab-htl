/*
给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。

美式键盘 中：

第一行由字符 "qwertyuiop" 组成。
第二行由字符 "asdfghjkl" 组成。
第三行由字符 "zxcvbnm" 组成。
*/

#include <stdio.h>
#include <stdlib.h>

void upper(char *c){
    if(*c >= 97)
        *c = (*c) - 32;
}

char** findWords(char** words, int wordsSize, int* returnSize) {
    char** res = (char**)malloc(sizeof(char*) * wordsSize);
    *returnSize = 0;
    int isCanAdd = 0;
    char chs[] = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 
    0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
    char c = 0;
    for(int i = 0; i < wordsSize; i++){
        c = words[i][0];
        upper(&c);
        int flag = chs[c - 'A'];
        int j = 1;
        while((c = words[i][j]) != '\0'){
            upper(&c);
            if(chs[c - 'A'] != flag){
                break;
            }
            j++;
        }
        if(c == '\0'){
            res[(*returnSize)++] = words[i];
        }
    }

    return res;
}



int main(){

    // char words[][10] = {"Hello","Alaska","Dad","Peace"};
    char** words = (char**)malloc(sizeof(char*) * 4);
    words[0] = "Hello";
    words[1] = "Alaska";
    words[2] = "Alaska";
    words[3] = "Dad";
    int len = 0;
    char** res = findWords(words, 4, &len);
    for(int i = 0; i < len; i++){
        printf("%s ", res[i]);
    }

    return 0;
}