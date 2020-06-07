//
//  MVPController.m
//  mvpTest
//
//  Created by codew on 11/7/18.
//  Copyright © 2018 codew. All rights reserved.
//

#import "MVPController.h"
#import "MVPView.h"
#import "MVPModel.h"
#import "Persenter.h"

@interface MVPController ()

@property (nonatomic, strong) Persenter * persenter;
@property (nonatomic, strong) MVPView * mvpView;
@property (nonatomic, strong) MVPModel * model;

@end

@implementation MVPController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.persenter = [[Persenter alloc] init];
    
    // View
    self.mvpView = [[MVPView alloc] init];
    _mvpView.frame = self.view.bounds;
    [self.view addSubview:_mvpView];
    
    self.model = [[MVPModel alloc] init];
    self.model.content = @"hi MVP";
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
