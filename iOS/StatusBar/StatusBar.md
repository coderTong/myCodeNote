info.plist文件中，
View controller-based status bar appearance项设为YES，则View controller对status bar的设置优先级高于application的设置。为NO则以application的设置为准，view controller的prefersStatusBarHidden方法无效，是根本不会被调用的。

调用

```
[[UIApplicationsharedApplication]setStatusBarStyle:UIStatusBarStyleLightContent];

```

需要先在info.plist设置View controller-based status bar appearance项设为NO，不设置默认View controller对status bar的设置优先级高于application的设置 ，所以上面代码会无效。


