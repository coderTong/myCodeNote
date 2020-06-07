//
//  MCBlock.m
//  Block
//
//  Created by yangyang38 on 2018/3/5.
//  Copyright © 2018年 yangyang. All rights reserved.
//

#import "MCBlock.h"

@implementation MCBlock

// 全局变量
int global_var = 4;
// 静态全局变量
static int static_global_var = 5;

- (void)method
{
    static int multiplier = 6;
    int(^Block)(int) = ^int(int num)
    {
//        __block
        return num * multiplier;
    };
    multiplier = 4;
    NSLog(@"result is %d", Block(2));
}

@end
