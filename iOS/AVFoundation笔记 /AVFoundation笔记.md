*   `AVAsset`资产类可通过这个类获得图片、文件、媒体库


*   `AVPlayerItem`音视频播放的元素


*   `AVPlayer`音视频播放器


*   `AVPlayerLayer`播放器的图层


// 视频拉伸参数
AVLayerVideoGravityResizeAspect

第1种模式`AVLayerVideoGravityResizeAspect`是按原视频比例显示，是竖屏的就显示出竖屏的，两边留黑；
第2种`AVLayerVideoGravityResizeAspectFill`是以原比例拉伸视频，直到两边屏幕都占满，但视频内容有部分就被切割了；
第3种`AVLayerVideoGravityResize`是拉伸视频内容达到边框占满，但不按原比例拉伸，这里明显可以看出宽度被拉伸了。





*   `@property (nonatomic) AVPlayerActionAtItemEnd actionAtItemEnd`指示当AVPlayerItem到达结束时间时播放器应执行的动作;

```
typedef NS_ENUM(NSInteger, AVPlayerActionAtItemEnd)
{
    /**
    指示当AVPlayerItem达到其结束时间时，播放器将自动前进到其
    队列中的下一个项目。此值仅支持AVQueuePlayer类的播放器。
    如果对非AVQueuePlayer类设置此值则会发生异常。
    */
    AVPlayerActionAtItemEndAdvance  = 0,

    /**
     播放完成后自动将rate设置为0.0使视频暂停。
    */
    AVPlayerActionAtItemEndPause    = 1,

    /**
    表示当AVPlayerItem达到其结束时间时，播放器将不采取任何行动。
    播放器的播放速度不会改变，其currentItem不会改变，其currentTime
    将会随着时间的推移而不断地增加或减少。
    */
    AVPlayerActionAtItemEndNone     = 2,
};
```

