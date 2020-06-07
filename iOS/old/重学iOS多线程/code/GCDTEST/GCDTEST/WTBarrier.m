//
//  WTBarrier.m
//  GCDTEST
//
//  Created by codew on 10/31/18.
//  Copyright © 2018 codew. All rights reserved.
//

#import "WTBarrier.h"

@interface WTBarrier()

@property (nonatomic, strong) NSMutableDictionary * dic;
@property (nonatomic, strong) dispatch_queue_t queue;

@end

@implementation WTBarrier

- (instancetype)init
{
    if (self = [super init]) {
    
        self.dic = [NSMutableDictionary dictionary];
        self.queue = dispatch_queue_create("com.codertomwu.t", DISPATCH_QUEUE_CONCURRENT);
    }
    
    return self;
}

- (id)objectForKey:(NSString *)key
{
    __block id obj;
    
    dispatch_sync(self.queue, ^{
       
        obj = [self.dic objectForKey:key];
    });
    
    return obj;
}

- (void)setObject:(id)obj forKey:(NSString *)key
{
    dispatch_barrier_async(self.queue, ^{
       
        [self.dic  setObject:obj forKey:key];
    });
}

@end
