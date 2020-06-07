//
//  RuntimeObject.m
//  CopyTest
//
//  Created by codew on 2018/4/19.
//  Copyright © 2018年 codew. All rights reserved.
//

#import "RuntimeObject.h"

#import <objc/runtime.h>

@implementation RuntimeObject


+ (void)load
{
    Method test = class_getInstanceMethod(self, @selector(test));
    Method otherTest = class_getInstanceMethod(self, @selector(otherTest));
    method_exchangeImplementations(test, otherTest);
}





- (void)test
{
    NSLog(@"%s", __func__);
 
    [self performSelector:<#(nonnull SEL)#> withObject:<#(nullable id)#> afterDelay:<#(NSTimeInterval)#>];
}
- (void)otherTest
{
    [self otherTest];
    NSLog(@"%s", __func__);
}

//+ (BOOL)resolveInstanceMethod:(SEL)sel
//{
//
//    // 如果是test方法 打印日志
//    if (sel == @selector(test)) {
//
//
//        NSLog(@"%s", __func__);
//        return YES;
//
//    } else {
//
//        // 返回父类的默认调用
//        return [super resolveInstanceMethod:sel];
//    }
//}
//
//- (id)forwardingTargetForSelector:(SEL)aSelector
//{
//    NSLog(@"%s", __func__);
//    return nil; // 返回nil让他走第三部
//
//}
//
//
//- (NSMethodSignature *)methodSignatureForSelector:(SEL)aSelector
//{
//    if (aSelector == @selector(test)) {
//        NSLog(@"%s", __func__);
//        //返回一个正确的方法签名
//        // v-void, 返回类型
//        // @==self, 代表第一个参数类型是id, 即self
//        // :--选择器, 代表第二参数SEL类型的, 即@selector(test)
//        return [NSMethodSignature signatureWithObjCTypes:"v@:"];
//    } else {
//
//        //返回父类的默认调用
//        return [super methodSignatureForSelector:aSelector];
//    }
//}
//
//- (void)forwardInvocation:(NSInvocation *)anInvocation
//{
//    NSLog(@"%s", __func__);
//}
@end
