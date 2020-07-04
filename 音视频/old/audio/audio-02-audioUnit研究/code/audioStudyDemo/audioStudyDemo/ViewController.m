//
//  ViewController.m
//  audioStudyDemo
//
//  Created by codew on 2018/2/7.
//  Copyright © 2018年 codew. All rights reserved.
//

#import "ViewController.h"
#import "NVAudioAdaptor.h"
@interface ViewController ()


@property (nonatomic, strong) NVAudioAdaptor * adaptor;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
    
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
    
   [self.adaptor start];
}

- (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event
{
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


- (NVAudioAdaptor *)adaptor
{
    
    if (!_adaptor) {
        
        _adaptor = [[NVAudioAdaptor alloc] init];
    }
    return _adaptor;
}

@end
