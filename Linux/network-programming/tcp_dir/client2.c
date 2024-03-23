/*************************************************************************
 > File Name: client2.c
 > Author: HuangTingling
 > Created Time: 2023��12��13�� ������ 19ʱ37��36��
 ************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<errno.h>
#include<ctype.h>
#include<pthread.h>
#include<arpa/inet.h>

#define SERV_PORT 1234

void sys_err(const char *str)
{
     perror(str);
     exit(1);
}

int main(int argc, char *argv[])
{

     int cfd = 0;
     char buf[BUFSIZ];
     struct sockaddr_in serv_addr;

     serv_addr.sin_family = AF_INET;
     serv_addr.sin_port = htons(SERV_PORT);
     inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr.s_addr);

     cfd = socket(AF_INET, SOCK_STREAM, 0);
     if(cfd == -1){
          sys_err("socket error");
     }

     int ret = connect(cfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr));
     if(ret == -1){
          sys_err("connect error");
     }

     while(1){

          int num = read(STDIN_FILENO, buf, sizeof(buf));
          write(cfd, buf, num);
          read(cfd, buf, num);
          write(STDOUT_FILENO, buf, num);
     }

     close(cfd);

     return 0;
}

