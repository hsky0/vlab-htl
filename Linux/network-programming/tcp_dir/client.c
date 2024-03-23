/*************************************************************************
 > File Name: client.c
 > Author: HuangTingling
 > Created Time: 2023��12��12�� ���ڶ� 18ʱ32��22��
 ************************************************************************/

// #include<stdio.h>
// #include<stdlib.h>
// #include<string.h>
// #include<unistd.h>
// #include<errno.h>
// #include<ctype.h>
// #include<pthread.h>
// #include<arpa/inet.h>

#include "wrap.h"

#define SERV_PORT 1234


int main(int argc, char *argv[])
{

     int cfd = 0;
     char buf[BUFSIZ];
     struct sockaddr_in srv_addr;
     int count = 0;

     srv_addr.sin_family = AF_INET;
     srv_addr.sin_port = htons(SERV_PORT);
     inet_pton(AF_INET, "127.0.0.1", &srv_addr.sin_addr.s_addr);

     cfd = Socket(AF_INET, SOCK_STREAM, 0);

     Connect(cfd, (struct sockaddr *)&srv_addr, sizeof(srv_addr));

     while (count < 10)
     {
          int ret = Read(STDIN_FILENO, buf, sizeof(buf));
          //write(STDOUT_FILENO, buf, ret);
          Write(cfd, buf, ret);

          Read(cfd, buf, ret);
          Write(STDOUT_FILENO, buf, ret);

          count++;
     }
     
     Close(cfd);

     return 0;
}

