//
//  ReverseList.h
//  Arithmetic
//
//  Created by kevin on 2018/3/26.
//  Copyright © 2018年 imooc. All rights reserved.
//

#import <Foundation/Foundation.h>

// 定义一个链表
struct Node {
    int data;
    struct Node *next;
};

@interface ReverseList : NSObject
// 链表反转
struct Node* reverseList(struct Node *head);
// 构造一个链表
struct Node* constructList(void);
// 打印链表中的数据
void printList(struct Node *head);

@end
