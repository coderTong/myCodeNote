# 一. AudioUnit介绍与实践


![Snip20180721_4](images/Snip20180721_4.png)


## 1. 认识AudioSession

```

在iOS的音视频开发中, 使用具体API之前都会先创建一个会话, 这里也不例外.

AudioSession 用于管理与获取iOS设备音频的硬件信息, 并且是以单例的形式存在.

```

```

AVAudioSession * audioSession = [AVAudioSession  sharedInstance];

  // 1\. 根据我们需要硬件设备提供的能力来设置类别

 [audioSession setCategory:AVAudioSessionCategoryPlayAndRecord  error:nil];

  // 2\. 设置I/O的buffer 越小则说明延迟越低

 NSTimeInterval bufferDuration = 0.002;

 [audioSession setPreferredIOBufferDuration:bufferDuration error:nil];

  // 3\. 设置采样率, 让硬件设备按照设置的采样率来采集或者播放音频

 double hwSampleRate = 44100.0;

 [audioSession setPreferredSampleRate:hwSampleRate error:nil];

  // 4\. 当设置完毕所有的参数之后就可以激活AudioSession了

 [audioSession setActive:YES error:nil];

 _audioSession = audioSession;


```


## 2. 构建AudioUnit

```

在创建并启用音频会话之后,就可以构建AudioUnit了.
构建AudioUnit的时候需要指定 类型(Type), 子类型(subtype),  以及厂商(Manufacture). 

类型(Type)就是在下一小节提到的四大类型的AudioUnit的Type
子类型(subtype)就是该大类型下面的子类型(比如Effect该大类型下面有 EQ, Compressor, limiter等子类型)
厂商(Manufacture)一般情况比较固定, 直接写成kAudioUnitManufacturer_Apple

```
创建一个RemoteIO类型的AudioUnit的描述的结构体

```

//====

  AudioComponentDescription ioUnitDescription;

 ioUnitDescription.componentType = kAudioUnitType_Output;

 ioUnitDescription.componentSubType = kAudioUnitSubType_RemoteIO;

 ioUnitDescription.componentManufacturer = kAudioUnitManufacturer_Apple;

 ioUnitDescription.componentFlags = 0;

 ioUnitDescription.componentFlagsMask = 0;


```


如何使用描述来构造真正的AudioUnit呢?

- 第一个, 直接使用AudioUnit裸的创建方式
- 第二个, 使用AUGrah和AUNode来创建.(其实一个AUNode就是对AudioUnit的封装, 可以理解为一个AudioUnit的Wrapper)

- 裸创建
```

  // 1\. 首先根据AudioUnit的描述, 找出实际的AudioUnit类型

 AudioComponent ioUnitRef = AudioComponentFindNext(NULL, &ioUnitDescription);

  // 2\. 声明一个AudioUnit引用

 AudioUnit ioUnitInstance;

  // 3.最后根据类型创建出这个AudioUnit实例

 AudioComponentInstanceNew(ioUnitRef, &ioUnitInstance);

```

-  使用AUGrah和AUNode来创建

```

// 根据AUGraph方式创建

  //1\. 首先声明并且实例化一个AUGraph

 AUGraph processingGraph;

 NewAUGraph(&processingGraph);

  // 2.然后按照AudioUnit的描述在AUGraph中增加一个AUNode

 AUNode ioNode;

 AUGraphAddNode(processingGraph, &ioUnitDescription, &ioNode);

  // 3.接下来打开AUGraph, 其实打开AUGraph的过程也是间接实例化AUGraph中所有的AUNode.

  //注意, 必须在获取AudioUnit之前打开整个AUGraph, 否则我们将不能从对应的AUNode中获取正确的AudioUnit

 AUGraphOpen(processingGraph);

  // 4\. 最后在AUGraph中某个Node里获得AudioUnit的引用

 AudioUnit ioUnit;

 AUGraphNodeInfo(processingGraph, ioNode, NULL, &ioUnit);


```

## 3. AudioUnit 的通用参数设置

这里说RemoteIO, 这个AudioUnit的参数设置, RemoteIO这个AudioUnit是与硬件IO相关的一个Unit ,它分为输入和输出端.


![IMG_6096](images/IMG_6096.jpg)

RemoteIO Unit 分为`Element0`和`Element1`

`Element0`控制输出端
`Element1`控制输入端



## 4. AudioUnit的分类

## 5. 构造一个AUGraph

