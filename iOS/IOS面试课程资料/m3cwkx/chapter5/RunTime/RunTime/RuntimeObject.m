//
//  RuntimeObject.m
//  RunTime
//
//  Created by yangyang38 on 2018/2/25.
//  Copyright © 2018年 yangyang. All rights reserved.
//

#import "RuntimeObject.h"
#import <objc/runtime.h>
@implementation RuntimeObject

void testIMP (void){
    NSLog(@"testIMP invoke");
}

+ (BOOL)resolveInstanceMethod:(SEL)sel
{
    if (sel == @selector(test)) {
        
        NSLog(@"resolveInstanceMethod:");
        return NO;
    }
    return [super resolveInstanceMethod:sel];
}

- (id)forwardingTargetForSelector:(SEL)aSelector{
    if (aSelector == @selector(test)) {
        NSLog(@"forwardingTargetForSelector:");
        return nil;
    }
    
    return [super forwardingTargetForSelector:aSelector];
}

- (NSMethodSignature *)methodSignatureForSelector:(SEL)aSelector{
    
    if (aSelector == @selector(test)) {
        NSLog(@"methodSignatureForSelector:");
        return [NSMethodSignature signatureWithObjCTypes:"v@:"];
    }
    
    return [super methodSignatureForSelector:aSelector];
}

- (void)forwardInvocation:(NSInvocation *)anInvocation
{
    NSLog(@"forwardInvocation:");
}

@end
