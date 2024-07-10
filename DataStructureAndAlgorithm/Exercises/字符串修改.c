#include <stdio.h>
#include <stdlib.h>
#include <string.h>


// int main(){


//     //char* str = "htl123";
//     char str[] = {'h', 't', 'l', '1', '2', '3'};
    
//     printf("str = %s\n", str);
//     //printf("str address = %d, &str = %d\n", str, &str);
//     //modifyString(&str);
//     str[3] = 'h';
//     printf("str = %s\n", str);
//     return 0;
// }
void modifyString(char* str){
    
    char* p = str;
    printf("in modify: %d\n", p);
    //p[2] = 'h';       // 代码段保护，不允许修改？？
    printf("str = %s\n", str);
    
}


int main(){


    char* str = "htl123";
    printf("in main: str = %d\n", str);
    int i = 0;
    while(str[i] != 0){
        printf("%c ", str[i]);
        i++;
    }

    modifyString(str);

    return 0;
}