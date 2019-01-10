当制作的私有 Framework的Header引入了Static Library的Header的时候，就会报一个non-modular header inside framework module的错误
解决方法是在podfile末尾加入，并且不使用use_framework!




```json

当制作自己的pod时，我的代码依赖FMDB第三方库， 编译或者运行demo的时候就会报这个错误。

解决办法一：(这个可以解决.h文件中引入了第三方库的头文件)
PROJECT >Buld Setting 中设置 Allow Non-modular Includes In Framework Modules 为 YES

解决办法二：(这个可以解决.h文件中没有引入第三方库的头文件)

1.  将#import "**.h" 第三方库写在 .m文件中，而不是放在.h文件中即可

将 #import "MBProgressHUD.h" 这行代码放在 UIView+Hint.m文件中




```
