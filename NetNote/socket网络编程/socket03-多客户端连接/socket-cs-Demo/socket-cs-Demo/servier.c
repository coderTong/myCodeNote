//
//  servier.c
//  socket-cs-Demo
//
//  Created by codew on 2018/3/25.
//  Copyright © 2018年 codew. All rights reserved.
//

#include "servier.h"

#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>

#include <string.h>

#include <syslog.h>


#define ERR_EXIT(m) \
do \
{ \
perror(m);\
exit(EXIT_FAILURE);\
}while(0)

int main(void)
{
    int listenfd;
    // 0.安装电话
    // 0 == IPPROTO_TCP
    listenfd = socket(PF_INET, SOCK_STREAM, 0);
    if (listenfd < 0) {
        ERR_EXIT("socket creat ok!");
    }
    
    // 1.地址初始化
    struct sockaddr_in servaddr;
    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;// 地址族
    servaddr.sin_port = htons(5188); // 这里要两个字节的端口号,是网络端口号
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY);// 本机的任意地址
    //servaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
    //inet_aton("127.0.0.1", &servaddr.sin_addr);
    
    // 设置地址重复利用
    int on = 1;
    int sockoptResult = setsockopt(listenfd, SOL_SOCKET, SO_REUSEADDR, &on, sizeof(on));
    if (sockoptResult < 0) {
        ERR_EXIT("sockoptResult ERROR!");
    }
    
    // 2.绑定电话号码
    int bindResult = bind(listenfd, (struct sockaddr *)&servaddr, sizeof(servaddr));
    if (bindResult < 0) {
        ERR_EXIT("bind ERROR!");
    }
    
    
    // 3.监听
    int listenResult = listen(listenfd, SOMAXCONN);
    if (listenResult < 0) {
        
        ERR_EXIT("listenResult ERROR!");
    }
    
    // 4.accept 将socket 主动==>被动
    struct sockaddr_in peerAddr;
    socklen_t peerLen = sizeof(peerAddr);//  长度一定要有初始值,否则accept会失败
    //accept会返回一个新的套接字, 称之为已连接套接字, 这个套接字算是主动套接字
    int conn = accept(listenfd, (struct sockaddr *)&peerAddr, &peerLen);
    if (conn < 0) {
        ERR_EXIT("acceptResult ERROR!");
    }
    
    printf("ip=%s  port=%d\n", inet_ntoa(peerAddr.sin_addr), ntohl(peerAddr.sin_port));
    
    //5. 接收数据
    char recvBuf[1024];
    int index = 0;
    while (1) {
        memset(recvBuf, 0, sizeof(recvBuf));
        int ret = read(conn, recvBuf, sizeof(recvBuf));
        fputc(recvBuf, stdout);
        
//        write(conn, recvBuf, sizeof(recvBuf));// 这样也是可以的
//        write(conn, recvBuf, strlen(recvBuf));// 回射回去
        
        write(conn, recvBuf, ret);
        
        printf("cccc----%zd", index);
        index++;
        
        if (index > 50) {
            break;
        }
    }
    
    close(listenfd);
    close(conn);
    return 0;
}
