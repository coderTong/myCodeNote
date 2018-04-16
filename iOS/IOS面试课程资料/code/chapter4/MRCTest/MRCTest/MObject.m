//
//  MObject.m
//  MRCTest
//
//  Created by yangyang38 on 2018/3/3.
//  Copyright © 2018年 yangyang. All rights reserved.
//

#import "MObject.h"

@implementation MObject

- (void)setObj:(id)obj
{
    if (_obj != obj) {
        [_obj release];
        _obj = [obj retain];
    }
}

@end
