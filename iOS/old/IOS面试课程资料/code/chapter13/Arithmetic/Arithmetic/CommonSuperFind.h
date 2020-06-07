//
//  CommonSuperFind.h
//  Arithmetic
//
//  Created by kevin on 2018/3/26.
//  Copyright © 2018年 imooc. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@interface CommonSuperFind : NSObject

// 查找两个视图的共同父视图
- (NSArray<UIView *> *)findCommonSuperView:(UIView *)view other:(UIView *)viewOther;

@end
