#include <stdio.h>
#include <stdlib.h>


// int main(){

//     char a[] = "C";
//     if(a[0] == 'C'){
//         printf("a is C\n");
//     } else {
//         printf("a is not C\n");
//     }

//     return 0;
// }


int getNum(char* c){
    int i = 0, num = 0;
    while(c[i] != '\0'){
        num = num * 10 + c[i] - 48;
        i++;
    }
    return num;
}

int main(){

    char c[] = "123456";
    printf("%d\n", getNum(c));

    return 0;
}