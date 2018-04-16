//
//  MObserver.m
//  KVO_TEST
//
//  Created by yangyang38 on 2018/3/3.
//  Copyright © 2018年 yangyang. All rights reserved.
//

#import "MObserver.h"
#import "MObject.h"
@implementation MObserver

- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context{
    
    if ([object isKindOfClass:[MObject class]] &&
         [keyPath isEqualToString:@"value"]) {
        
        // 获取value的新值
        NSNumber *valueNum = [change valueForKey:NSKeyValueChangeNewKey];
        NSLog(@"value is %@", valueNum);
    }
}


@end
