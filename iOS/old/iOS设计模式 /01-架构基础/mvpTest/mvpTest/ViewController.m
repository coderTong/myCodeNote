//
//  ViewController.m
//  mvpTest
//
//  Created by codew on 11/7/18.
//  Copyright © 2018 codew. All rights reserved.
//

#import "ViewController.h"
#import "MVP/MVPController.h"
@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    
    dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)(2.0 * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
        [self jupMVPVC];
    });
    // Do any additional setup after loading the view, typically from a nib.
}


- (void)jupMVPVC{
    
    MVPController *vc = [[MVPController alloc] init];
    [self presentViewController:vc animated:YES completion:nil];
}

@end
