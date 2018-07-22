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

每个 `Element`有分为`Input Scope` 和 `Output  Scope`


如果想使用扬声器的声音播放功能, 那么必须将这个Unit的 `Element0 `的  `Output  Scope`
和`Speaker(扬声器 或耳机)`进行连接.


```

// 如果想使用扬声器的声音播放功能, 那么必须将这个Unit的 `Element0 `的 `Output Scope`和`Speaker`进行连接.

 OSStatus status = noErr;

 UInt32 oneFlag = 1;

 UInt32 bueZero = 0; // Element0

 status = AudioUnitSetProperty(ioUnit,

 kAudioOutputUnitProperty_EnableIO,

 kAudioUnitScope_Output,

 bueZero,

 &oneFlag,

 sizeof(oneFlag));

 CheckStatus(status, @"Could not Connect To Speaker", YES);


```



如果想使用麦克风的录音功能, 那么必须将这个Unit的 `Element1`的 `Input Scope`和麦克风进行连接

```

// 启用麦克风

  // 如果想使用麦克风的录音功能, 那么必须将这个Unit的 `Element1`的 `Input Scope`和麦克风进行连接

 UInt32 busOne = 1; // Element1

  AudioUnitSetProperty(ioUnit,

  kAudioOutputUnitProperty_EnableIO,

 kAudioUnitScope_Input,

 busOne,

 &oneFlag,

 sizeof(oneFlag));

```
上面这段代码就是把AudioUnit的 `Element1`的`Input Scope`和麦克风进行连接, 连接成功之后, 就应该给AudioUnit设`置数据格式`了, AudioUnit的数据格式分为输入和输出两个部分, 下面先来看一个AudioUnit Stream Format的描述..

```


/// 给AudioUnit设`置数据格式`

 UInt32 bytesPerSample = sizeof(Float32); // 采样深度?

  AudioStreamBasicDescription asbd;

 bzero(&asbd, sizeof(asbd));

 asbd.mFormatID = kAudioFormatLinearPCM;

 asbd.mSampleRate = 44100;

 asbd.mBitsPerChannel = 2;

 asbd.mFramesPerPacket = 1; // 仿佛固定为1, NVT也是1

 asbd.mFormatFlags = kAudioFormatFlagsNativeFloatPacked | kAudioFormatFlagIsNonInterleaved; // NVT 是kLinearPCMFormatFlagIsSignedInteger | kAudioFormatFlagIsPacked;

 asbd.mBitsPerChannel = 8 * bytesPerSample;

 asbd.mBytesPerFrame = bytesPerSample;

 asbd.mBytesPerPacket = bytesPerSample;


```

上面这段代码展示了如何填充AudioStreamBasicDescription结构体, 其实在iOS平台做音视频开发久了就会知道: `不论音频还是视频的API都会接触到很多StreamBasic Description. 改Description就是用来描述音视频具体格式的.`  下面是上述代码的分析

-  mFormatID 参数可用来指定音频的编码格式. 此处指定音频的编码格式为PCM格式.
- 接下来是设置声音的采样率, 声道数, 以及`每个Packet有几个Frame`

- mFormatFlags 是用来描述声音表示格式的参数, 代码中的第一个参数`kAudioFormatFlagsNativeFloatPacked`指定每个Sample的表示格式是Float格式, 这点类似于之前讲解的每个Sample都是使用两个字节(SInt16)来表示.. 第二个参数`kAudioFormatFlagIsNonInterleaved`,  NonInterleaved字面理解这个单词的意思是非交错的,其实对于音频来讲就是`左右声道是非交错存放的`实际的音频数据会存储在一个`AudioBufferList`结构中的变量mBuffers中, 如果mFormatFlags 指定的是`NonInterleaved`那么左声道就会在mBuffers[0]里面, 右声道就会在mBuffers[1]里面; 二如果`mFormatFlags`指定的是`Interleaved`的话, 那么左右声道就会交错排列在mBuffer[0]里面, 理解这一点对于后续的开发将十分重要的.

- mBitsPerChannel 表示的是一个声道的音频数据用多少位来表示, 前面已经提到过每个采样使用Float来表示, 所以这里是使用8乘以`每个采样的字节数`来赋值

- 最终的参数`mBytesPerFrame`和`mBytesPerPacket`的赋值, 这里需要根据 `mFormatFlags`的值来进行分配, 如果是`NonInterleaved`的情况下, 就赋值为bytesPerSample(`因为左右声道是分开存放的`); 如果是`Interleaved`的话,那么就应该是bytesPerSample * channels( `因为左右声道是交错存放的` ), 这样才能表示一个Frame里面到底有多少个byte


```

snd_strm->streamDesc.mSampleRate  = clock_rate;

 snd_strm->streamDesc.mFormatID  = kAudioFormatLinearPCM;

 snd_strm->streamDesc.mFormatFlags = kLinearPCMFormatFlagIsSignedInteger | kAudioFormatFlagIsPacked;

  // TODO

  /* !!! IMP !!! */

  // We specifically configure core audio in stereo.

 snd_strm->streamDesc.mBitsPerChannel  = 16;

 snd_strm->streamDesc.mChannelsPerFrame = 1;

 snd_strm->streamDesc.mBytesPerFrame = snd_strm->streamDesc.mBitsPerChannel * snd_strm->streamDesc.mChannelsPerFrame / 8;

 snd_strm->streamDesc.mFramesPerPacket = 1;

 snd_strm->streamDesc.mBytesPerPacket  = snd_strm->streamDesc.mBytesPerFrame * snd_strm->streamDesc.mFramesPerPacket;

 snd_strm->inputBufferList->mNumberBuffers = 1;

 snd_strm->inputBufferList->mBuffers[0].mNumberChannels = snd_strm->streamDesc.mChannelsPerFrame;


```



至此, 我们就完全构造好了这个BasicDescription结构体, 下面将这个结构体设置给对应的AudioUnit, 代码:

```

// 至此, 我们就完全构造好了这个BasicDescription结构体, 下面将这个结构体设置给对应的AudioUnit, 代码:

  AudioUnitSetProperty(ioUnit,

  kAudioUnitProperty_StreamFormat,

 kAudioUnitScope_Output,

 1,

 &asbd,

 sizeof(asbd));

```

## 4. AudioUnit的分类

## 5. 构造一个AUGraph

