/*************************************************************************
 > File Name: server3.c
 > Author: HuangTingling
 > Created Time: 2023��12��13�� ������ 19ʱ23��12��
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

     int lfd = 0, cfd = 0;
     char buf[BUFSIZ], client_IP[1024];
     struct sockaddr_in sock_addr, clit_addr;
     socklen_t clit_addr_len;

     sock_addr.sin_family = AF_INET;
     sock_addr.sin_port = htons(SERV_PORT);
     sock_addr.sin_addr.s_addr = htonl(INADDR_ANY);


     lfd = socket(AF_INET, SOCK_STREAM, 0);
     if(lfd == -1){
          sys_err("socket error");
     }

     int bindflag = bind(lfd, (struct sockaddr *)&sock_addr, sizeof(sock_addr));
     if(bindflag == -1){
          sys_err("bind error");
     }

     listen(lfd, 128);

     clit_addr_len = sizeof(clit_addr);
     cfd = accept(lfd, (struct sockaddr *)&clit_addr, &clit_addr_len);
     if(cfd == -1){
          sys_err("accept error");
     }

     printf("client ip: %s port: %d\n", 
     inet_ntop(AF_INET, &clit_addr.sin_addr.s_addr, client_IP, sizeof(client_IP)),
     ntohs(clit_addr.sin_port));

  

     while(1){

          int ret = read(cfd, buf, sizeof(buf));
          write(STDOUT_FILENO, buf, ret);

          for(int i = 0; i < ret; i++){
               buf[i] = toupper(buf[i]);
          }

          write(cfd, buf, ret);
     }

     close(lfd);
     close(cfd);



     return 0;
}

