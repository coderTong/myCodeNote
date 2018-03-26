//
//  clientTest.c
//  socket-cs-Demo
//
//  Created by codew on 2018/3/25.
//  Copyright © 2018年 codew. All rights reserved.
//

#include "clientTest.h"



#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>

#define ERR_EXIT(m) \
do \
{ \
perror(m);\
exit(EXIT_FAILURE);\
}while(0)

int main(void)
{
    int sock;
    // 0.安装电话
    // 0 == IPPROTO_TCP
    sock = socket(PF_INET, SOCK_STREAM, 0);
    if (sock < 0) {
        ERR_EXIT("socket creat error!");
    }
    
    // 1.地址初始化
    struct sockaddr_in servaddr;
    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;// 地址族
    servaddr.sin_port = htons(5188); // 这里要两个字节的端口号,是网络端口号
    inet_aton("165.227.50.226", &servaddr.sin_addr);
    
    int connectResult = connect(sock, (const struct sockaddr *)&servaddr, sizeof(servaddr));
    if (connectResult < 0) {
        ERR_EXIT("connectResult error!");
    }
    
    while (<#condition#>) {
        <#statements#>
    }
    
    close(sock)
    return 0;
}
