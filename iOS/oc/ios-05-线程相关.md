# GCD
1. 创建

```

DISPATCH_QUEUE_CONCURRENT // 并发
DISPATCH_QUEUE_SERIAL  // 串行

@property (nonatomic, strong) dispatch_queue_t operationQueue;
dispatch_queue_create("MVCP Operation Queue", DISPATCH_QUEUE_SERIAL);

```