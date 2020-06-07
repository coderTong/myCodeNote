//
//  MObject.m
//  KVO_TEST
//
//  Created by yangyang38 on 2018/3/3.
//  Copyright © 2018年 yangyang. All rights reserved.
//

#import "MObject.h"

@implementation MObject

- (id)init
{
    self = [super init];
    if (self) {
        _value = 0;
    }
    return self;
}

- (void)increase
{
    //直接为成员变量赋值
    [self willChangeValueForKey:@"value"];
    _value += 1;
    [self didChangeValueForKey:@"value"];
}

@end
