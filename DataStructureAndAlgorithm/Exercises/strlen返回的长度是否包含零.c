#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*strlen返回的字符串长度不包含0*/

int main(){

    char s[] = "hbnrb";
    int slen = strlen(s);
    printf("s size = %d\n", slen);

    return 0;
}