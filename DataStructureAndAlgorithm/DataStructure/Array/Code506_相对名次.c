/*
给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。

运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：

名次第 1 的运动员获金牌 "Gold Medal" 。
名次第 2 的运动员获银牌 "Silver Medal" 。
名次第 3 的运动员获铜牌 "Bronze Medal" 。
从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cmp(const void* a, const void* b){
    return *((int*)a) < *((int*)b);
}

struct ScoreSort{
    int score;
    int index;
};


char* intTostr(int num){
    char temp[10] = {0};
    char *str = (char*)malloc(sizeof(char) * 10);
   
    int i = 0, j = 0;
    while(num){
        temp[i] = (char)(num % 10 + 48);
        num = num / 10;
        i++;
        
    }
    i--;
    for(i ; i >= 0; i--){
        str[j++] = temp[i];
    }
    str[j] = 0;
    return str;
}



// leetcode上相关解法
// char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
//     char** res = (char**)malloc(sizeof(char*) * scoreSize);
//     if(res == NULL){
//         return NULL;
//     }
//     for(int i = 0; i < scoreSize; i++){
//         res[i] = (char *)malloc(20 * sizeof(char));
//     }
//     *returnSize = scoreSize;
//     struct ScoreSort* scoreSort = (struct ScoreSort*)malloc(sizeof(struct ScoreSort) * scoreSize); 
//     for(int i = 0; i < scoreSize; i++){
//         scoreSort[i].score = score[i];
//         scoreSort[i].index = i; 
//     }
//     qsort(scoreSort, scoreSize, sizeof(struct ScoreSort), cmp);
    

//     for(int i = 0; i < scoreSize; i++){
//         if(i == 0){
//             strcpy(res[scoreSort[i].index], "Gold Medal");

//         } else if(i == 1){
//             strcpy(res[scoreSort[i].index], "Silver Medal");

//         } else if(i == 2){
//             strcpy(res[scoreSort[i].index], "Bronze Medal");

//         } else{
//             // z这里存在大问题
//             sprintf(res[scoreSort[i].index], "%d", i + 1);
//         }
//     }
//     free(scoreSort);

//     return res;
// }



char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    char** res = (char**)malloc(sizeof(char*) * scoreSize);
    if(res == NULL){
        return NULL;
    }
    for(int i = 0; i < scoreSize; i++){
        res[i] = (char *)malloc(20 * sizeof(char));
    }
    *returnSize = scoreSize;
    struct ScoreSort* scoreSort = (struct ScoreSort*)malloc(sizeof(struct ScoreSort) * scoreSize); 
    for(int i = 0; i < scoreSize; i++){
        scoreSort[i].score = score[i];
        scoreSort[i].index = i; 
    }
    qsort(scoreSort, scoreSize, sizeof(struct ScoreSort), cmp);
    

    for(int i = 0; i < scoreSize; i++){
        if(i == 0){
           res[scoreSort[i].index] = "Gold Medal";

        } else if(i == 1){
            res[scoreSort[i].index] = "Silver Medal";

        } else if(i == 2){
            res[scoreSort[i].index] = "Bronze Medal";

        } else{
            // z这里存在大问题
            char* temp = intTostr(i + 1);
            res[scoreSort[i].index] = temp;
        }
    }
    free(scoreSort);

    return res;
}

int main(){

    int a[] = {5, 4, 3, 2, 1};
    int len = 0;
    char** res = findRelativeRanks(a, 5, &len);
    for(int i = 0; i < len; i++){
        printf("%s\n", res[i]);
    }



    return 0;
}

