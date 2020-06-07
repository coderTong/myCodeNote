# sendSubviewToBack

```

//将view显示在最后

```

[输入框挡住导航栏-然后用sendSubviewToBack解决](http://www.cnblogs.com/kw-ios/p/4182263.html)




# UITextField 删除

```

@class  NVTextField;

@protocol NVTextFieldDelegate <NSObject>

- (void)nvTextFieldDeleteBackward:(NVTextField *)textField;

@end

@interface NVTextField : UITextField

@property (nonatomic, weak) id <NVTextFieldDelegate> nvDelegate;;

@end

@implementation NVTextField

- (void)deleteBackward {

 [super  deleteBackward];

 if ([self.nvDelegate respondsToSelector:@selector(nvTextFieldDeleteBackward:)]) {

 [self.nvDelegate  nvTextFieldDeleteBackward:self];

 }

}

@end

```