
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <unistd.h>
// #include <errno.h>
// #include <ctype.h>
// #include <pthread.h>
// //#include <sys/types.h>          /* See NOTES */
// //#include <sys/socket.h>
// // #include <netinet/in.h>
// // #include <netinet/ip.h> /* superset of previous */

// #include <arpa/inet.h>

#include "wrap.h"

#define SERV_PORT 1234

int main(int argc, char *argv[]){

    int lfd = 0, cfd = 0, ret = 0;
    char buf[BUFSIZ], client_IP[1024];

    struct sockaddr_in serv_addr, clit_addr;
    socklen_t clit_addr_len;

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(SERV_PORT);      //port = 9527
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);

    lfd = Socket(AF_INET, SOCK_STREAM, 0);
    Bind(lfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr));
    Listen(lfd, 128);

    clit_addr_len = sizeof(clit_addr);
    cfd = Accept(lfd, (struct sockaddr *)&clit_addr, &clit_addr_len);

    printf("client ip: %s port: %d\n", 
    inet_ntop(AF_INET, &clit_addr.sin_addr.s_addr, client_IP, sizeof(client_IP)), 
    ntohs(clit_addr.sin_port));

    while (1)
    {
        ret = Read(cfd, buf, sizeof(buf));
        Write(STDIN_FILENO, buf, ret);

        for(int i = 0; i < ret; i++){
            buf[i] = toupper(buf[i]);
        }

        Write(cfd, buf, ret);
    }
    
    Close(lfd);
    Close(cfd);
    return 0;
}