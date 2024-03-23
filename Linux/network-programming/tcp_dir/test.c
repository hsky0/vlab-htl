#include <stdio.h>
#include "wrap.h"



int main(){


    char c[20];

    while(1){
        Readline(STDIN_FILENO, c, 5);
        printf("str: %s\n", c);
    }
    
        
    return 0;
}