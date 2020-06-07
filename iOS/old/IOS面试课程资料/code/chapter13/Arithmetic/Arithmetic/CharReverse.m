//
//  CharReverse.m
//  Arithmetic
//
//  Created by kevin on 2018/3/26.
//  Copyright © 2018年 imooc. All rights reserved.
//

#import "CharReverse.h"

@implementation CharReverse

void char_reverse(char* cha)
{
    // 指向第一个字符
    char* begin = cha;
    // 指向最后一个字符
    char* end = cha + strlen(cha) - 1;
    
    while (begin < end) {
        // 交换前后两个字符,同时移动指针
        char temp = *begin;
        *(begin++) = *end;
        *(end--) = temp;
    }
}

@end
