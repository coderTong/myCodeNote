//
//  Persenter.m
//  mvpTest
//
//  Created by codew on 11/7/18.
//  Copyright © 2018 codew. All rights reserved.
//

#import "Persenter.h"
#import "MVPView.h"
#import "MVPModel.h"

@interface Persenter ()

@property (nonatomic, strong) MVPView * view;
@property (nonatomic, strong) MVPModel * model;

@end

@implementation Persenter

- (void)printTask
{
    
    NSString *printContent = _model.content;
    [_view printOnView:printContent];
}

@end
