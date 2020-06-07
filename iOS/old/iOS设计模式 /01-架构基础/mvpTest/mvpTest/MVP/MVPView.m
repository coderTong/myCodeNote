//
//  MVPView.m
//  mvpTest
//
//  Created by codew on 11/7/18.
//  Copyright © 2018 codew. All rights reserved.
//

#import "MVPView.h"

@interface MVPView ()

@property (nonatomic, strong) UILabel * lblContent;

@end

@implementation MVPView

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.backgroundColor = [UIColor lightGrayColor];
        
        self.lblContent = [[UILabel alloc] init];
        [self addSubview:_lblContent];
        self.lblContent.frame = CGRectMake(0, 100, 300, 30);
        self.lblContent.textAlignment = NSTextAlignmentCenter;
        [self.lblContent setTextColor:[UIColor blackColor]];
    }
    return self;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/
- (void)printOnView:(NSString *)content
{
    
}

@end
