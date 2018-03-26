//
//  ViewController.m
//  csClientDemo
//
//  Created by codew on 2018/3/25.
//  Copyright © 2018年 codew. All rights reserved.
//

#import "ViewController.h"
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>


@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *ipAddTextF;
@property (weak, nonatomic) IBOutlet UITextField *portTextF;
@property (weak, nonatomic) IBOutlet UIButton *connetBtn;

@property (weak, nonatomic) IBOutlet UITextField *contentTextF;

@property (weak, nonatomic) IBOutlet UIButton *sendBBtn;
@property (weak, nonatomic) IBOutlet UILabel *msgLbl;

///  客户端 socket
@property (nonatomic, assign) int clientSocket;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)connetClick:(id)sender {
    
    
    
    if (self.connetBtn.selected) {
        // 1. 断开连接
        close(self.clientSocket);
        self.connetBtn.selected = NO;
        return;
    }
    self.connetBtn.selected =  !self.connetBtn.selected;
    
    NSLog(@"ip: %@, port: %@", self.ipAddTextF.text, self.portTextF.text);
    
    if ([self connectTo:self.ipAddTextF.text port:self.portTextF.text.intValue]) {
        self.msgLbl.text = @"连接成功";
    } else {
        self.msgLbl.text = @"连接失败";
    }
    
}

- (BOOL)connectTo:(NSString *)hostname port:(int)port {
    // 1. socket
    /**
     参数
     
     domain:    协议域，AF_INET（IPV4的网络开发）
     type:      Socket 类型，SOCK_STREAM(TCP)/SOCK_DGRAM(UDP，报文)
     protocol:  IPPROTO_TCP，协议，如果输入0，可以根据第二个参数，自动选择协议
     
     返回值
     socket，如果 > 0 就表示成功
     */
    int clientSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (clientSocket < 0) {
        NSLog(@"socket creat error!");
    }
    self.clientSocket = clientSocket;
    
    // 2. 连接到服务器
    /**
     参数
     1> 客户端socket
     2> 指向数据结构sockaddr的指针，其中包括目的端口和IP地址
     服务器的"结构体"地址
     提示：C 语言中没有对象
     3> 结构体数据长度
     
     返回值
     0 成功/其他 错误代号，非0即真
     */
    struct sockaddr_in serverAddress;
    // 协议族
    serverAddress.sin_family = AF_INET;
    // 主机地址 - inet_addr 函数可以把ip地址转换成一个整数
    serverAddress.sin_addr.s_addr = inet_addr([hostname UTF8String]);
    // 端口
    serverAddress.sin_port = htons(port);
    
    int result = connect(clientSocket, (const struct sockaddr *)&serverAddress, sizeof(serverAddress));
    
    return (result == 0);
}

- (IBAction)sendClick:(id)sender {
    
    NSLog(@"contentTextF: %@", self.contentTextF.text);
    
    self.msgLbl.text = [self sendAndRecv:self.contentTextF.text];
}

- (NSString *)sendAndRecv:(NSString *)msg {
    // 1. 发送消息
    /**
     参数
     1> 客户端socket
     2> 发送内容地址 void * == id
     3> 发送内容长度
     4> 发送方式标志，一般为0
     返回值
     如果成功，则返回发送的字节数，失败则返回SOCKET_ERROR
     */
    NSLog(@"%s", msg.UTF8String);
    ssize_t sendLen = send(self.clientSocket, msg.UTF8String, strlen(msg.UTF8String), 0);
    
    NSLog(@"发送了 %ld 字节", sendLen);
    
    // 2. 接收消息
    /**
     参数
     1> 客户端socket
     2> 接收内容缓冲区地址
     3> 接收内容缓存区长度
     4> 接收方式，0表示阻塞，必须等待服务器返回数据
     返回值
     如果成功，则返回读入的字节数，失败则返回SOCKET_ERROR
     */
    uint8_t buffer[100];
    ssize_t recvLen = recv(self.clientSocket, buffer, sizeof(buffer), 0);
    NSLog(@"接收到 %ld 字节", recvLen);
    
    NSData *data = [NSData dataWithBytes:buffer length:recvLen];
    NSString *str = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
    
    
    [self.view endEditing:YES];
    return str;
}


@end
