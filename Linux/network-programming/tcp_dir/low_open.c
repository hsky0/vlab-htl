/*************************************************************************
 > File Name: low_open.c
 > Author: HuangTingling
 > Created Time: 2023��12��16�� ������ 13ʱ59��38��
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<errno.h>
#include<ctype.h>
#include<pthread.h>
#include<arpa/inet.h>
#include <fcntl.h>

void sys_err(const char *str)
{
     perror(str);
     exit(1);
}

int main(int argc, char *argv[])
{

    int fd;
    char buf[] = "Let's go!\n";
    char str[] = "";

    fd = open("data.txt", O_CREAT | O_RDWR | O_TRUNC);
    if(fd == -1){
        sys_err("open() erro!");
    }

    printf("fd = %d\n", fd);

    if(write(fd, buf, sizeof(buf)) == -1){
        sys_err("write() error!");
    }

    close(fd);

    fd = open("data.txt", O_RDONLY);
    if(fd == -1){
        sys_err("open() erro!");
    }

    printf("fd = %d\n", fd);

    if(read(fd, str, sizeof(str)) == -1){
        sys_err("read() error!");
    }

    printf("str:%s\n", str);

    close(fd);


    return 0;
}

