//   ====

scrollView 先铺满super

ContainView 上下左右0, 加一个centerx 加一个高




// ===

@property(nonatomic) CGPoint contentOffset;
这个属性用来表示UIScrollView滚动的位置
（其实就是内容左上角与scrollView左上角的间距值）

@property(nonatomic) CGSize contentSize;
这个属性用来表示UIScrollView内容的尺寸，滚动范围（能滚多远）

@property(nonatomic) UIEdgeInsets contentInset;
这个属性能够在UIScrollView的4周增加额外的滚动区域，一般用来避免scrollView的内容被其他控件挡住

