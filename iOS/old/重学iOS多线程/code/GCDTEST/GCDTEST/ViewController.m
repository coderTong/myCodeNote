//
//  ViewController.m
//  GCDTEST
//
//  Created by codew on 10/31/18.
//  Copyright © 2018 codew. All rights reserved.
//

#import "ViewController.h"

//#import <OSS>

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    NSLog(@"main......");
    
    
    OSSpinLock;
    
    NSLog(@"main  end");
    // Do any additional setup after loading the view, typically from a nib.
}
- (IBAction)btnCLick:(id)sender {
    
    NSLog(@"click");
    [self testGroup];
    
    
//    @synchronized (<#token#>) {
//        <#statements#>
//    }
    
    
}


- (void)test1{
    
    
    
    // 异步加并发,  开启多少个线程不确定
//    dispatch_queue_t queueC = dispatch_queue_create("com.codertomwu.test", DISPATCH_QUEUE_CONCURRENT);
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发1");
//
//    });
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发2");
//
//    });
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发3");
//
//    });
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发4");
//
//    });
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发5");
//
//    });
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发6");
//
//    });
//    dispatch_async(queueC, ^{
//
//        NSLog(@"--------异步加并发7");
//
//    });
    
    
    // 异步加串行, 始终只会开启一个人线程
//    dispatch_queue_t queue = dispatch_queue_create("com.codertomwu.test", DISPATCH_QUEUE_SERIAL);
//    dispatch_async(queue, ^{
//
//        NSLog(@"-------异步加串行1");
//    });
//    dispatch_async(queue, ^{
//
//        NSLog(@"-------异步加串行2");
//    });
//    dispatch_async(queue, ^{
//
//        NSLog(@"-------异步加串行3");
//    });
//    dispatch_async(queue, ^{
//
//        NSLog(@"-------异步加串行4");
//    });
//    dispatch_async(queue, ^{
//
//        NSLog(@"-------异步加串行5");
//    });
    
    
    // 异步线程加主队列
//    dispatch_async(dispatch_get_main_queue(), ^{
//
//        NSLog(@"-------异步线程加主队列");
//
//    });
//    NSLog(@"end");
    
    
    
    // 同步加并发, 不开线程
//    dispatch_queue_t queueCS = dispatch_queue_create("com.codertomwu.t", DISPATCH_QUEUE_CONCURRENT);
//    dispatch_sync(queueCS, ^{
//
//        NSLog(@"同步加并发1");
//    });
//    dispatch_sync(queueCS, ^{
//
//        NSLog(@"同步加并发2");
//    });
//    dispatch_sync(queueCS, ^{
//
//        NSLog(@"同步加并发3");
//    });
//    dispatch_sync(queueCS, ^{
//
//        NSLog(@"同步加并发4");
//    });
//    NSLog(@"同步加并发end");
//
//
//
//     //同步加串行,
//    dispatch_queue_t queueSS = dispatch_queue_create("com.tomwu.c", DISPATCH_QUEUE_SERIAL);
//    dispatch_sync(queueSS, ^{
//
//        NSLog(@"同步加串行1");
//    });
//    dispatch_sync(queueSS, ^{
//
//        NSLog(@"同步加串行2");
//    });
//    dispatch_sync(queueSS, ^{
//
//        NSLog(@"同步加串行3");
//    });
//    dispatch_sync(queueSS, ^{
//
//        NSLog(@"同步加串行4");
//    });
//    NSLog(@"同步加串行----end");
    
    
    // 卡死.....
//    dispatch_sync(dispatch_get_main_queue(), ^{
//
//        NSLog(@"同步加 主线程......");
//    });
    
}


- (void)mokeTs{
    
    
    dispatch_async(dispatch_get_global_queue(0, 0), ^{
       
        
        NSLog(@"1");
        
        [self performSelector:@selector(test2) withObject:nil afterDelay:0];
       
        NSLog(@"3");
    });
    
}


- (void)test2{
    
    NSLog(@"2");
}





// ================================

- (void)testGroup{
    
    // 创建一个group
    dispatch_group_t group = dispatch_group_create();
    dispatch_queue_t queue = dispatch_queue_create("com.codertomwu.t", DISPATCH_QUEUE_CONCURRENT);
    
    for (int i = 0; i < 4; i++) {
        
        dispatch_group_async(group, queue, ^{
            
            [NSThread sleepForTimeInterval:3];
            NSLog(@"%d", i);
        });
    }
    
    
    dispatch_group_notify(group, queue, ^{
       
        
        NSLog(@"所有s超时任务ok");
    });
    
}

@end
