

# 4. AudioUnit的分类

iOS按照AudioUnit的用途将AudioUnit分为五大类型

<!-- more -->

### 1. Effect Unit
类型`kAudioUnitType_Effect`, 主要提供声音特效处理的功能.

- 均衡效果器: 子类型是`kAudioUnitSubType_NBandEQ`, 
```

主要作用是为声音的某些频带增强或者减弱能量, 该效果器需要指定多个频带, 然后为各个频带设置宽度以及增益, 最终将改变声音在频域上的能量分布.

```

- 压缩效果器: 子类型是`kAudioUnitSubType_DynamicsProcessor`

```

主要作用是当声音较小的时候可以提高声音的能量, 当声音的能量超过了设置的阈值时, 可以降低声音的能量, 当然应合理的设置作用时间, 释放时间以及触发值, 使得最终可以将声音在时域上的能量压缩到一定范围之内

```

- 混响效果器: 子类型是`kAudioUnitSubType_Reverb2`

```

对于人声处理来讲这是非常重要的效果器, 可以想象自己身处在一个空房子中, 如果有非常多反射声和原始声音叠加在一起,那么从听感上可能会更有震撼力,但是同时原始声音也会变得更加模糊, 原始声音的一些细节会被遮盖掉, 所以混响设置的大或者小对于不同的人来说会很不一致, 可以根据自己的喜好来进行设置.

```

- 高通`kAudioUnitSubType_HighPassFilter`
- 低通`kAudioUnitSubType_LowPassFilter`
- 带通`kAudioUnitSubType_BandPassFilter`
- 延迟`kAudioUnitSubType_Delay`
- 压限`kAudioUnitSubType_PeakLimiter`


### 2. Mixer Units
类型是`kAudioUnitType_Mixer`, 主要提供mix多路声音的功能.

- MultiChannelMixer: 子类型是`kAudioUnitSubType_MultiChannelMixer`, 该效果器将是`本书重点介绍的对象`, 它是多路声音混音的效果器, 可以接收多路音频的输入, 还可以分别调整每一路音频的增益与开关,  `并将多路音频合并成一路`, 该效果器在处理音频的图状结构中非常有用..


### 3.I/O Units

类型是`kAudioUnitType_Output`, 主要做I/O

- RemoteIO: 子类类型是`kAudioUnitSubType_RemoteIO`, 从名字上可以看出, 这是用来采集音频与播放音频的, 其实当开发者的应用场景中要使用麦克风及扬声器的时候会用到该AudioUnit

- Generic Output: 子类型`kAudioUnitSubType_GenericOutput`, 当开发者需要进行离线处理, 或者说在`AUGRaph`中不使用Speaker(扬声器)来驱动整个数据流, 而是希望使用一个输出( 可以放入内存队列或者进行磁盘I/O操作 )来驱动数据流时, 就使用该子类型.


### 4. Format Converter Units
类型`kAudioUnitType_FormatConverter`, 主要用于提供格式转换的功能. 比如:采样格式由Float到SInt16的转换,交错和平铺的格式转换, 单双声道的转换等, 其子类了型及用途说明如下

- AUConverter: 子类型是`kAudioUnitSubType_AUConverter`, `它将是本书要重点介绍的格式转换效果器`, 
当某些效果器对输入的音频格式有明确的要求时(比如3D Mixer Unit就必须使用UInt16格式的Sample), 
或者开发者将音频数据输入给一些其他的编码器进行编码,
又或者开发者想使用SInt16格式的PCM裸数据在其他CPU上进行音频算法计算等的场景下, 
就需要使用到这个`ConvertNode`了.

一个典型例子
```
由FFmpeg解码出来的PCM数据是SInt16格式的, 因此不能直接输送给RemoteIO Unit进行播放, 所以需要构建一个`ConvertNode`将SInt16格式表示的数据转换为Float32格式表示的数据, 然后再输送给RemoteIO Unit , 最终才能正常播放出来.

```

- Time Pitch: 子类型是`kAudioUnitSubType_NewTimePitch` 即变速变调效果器, 这是一个很有意思的效果器, 可以对声音的音高, 速度进行调整, 像"会说话的Tom猫"类似的应用场景就可以使用这个效果器来实现


### 5. Generator Units
类型是`kAudioUnitType_Generator`, 在开发中我们经常使用它来提供播放器的功能. 其子类型及用途说明如下.

- AudioUnitFilePlayer: 子类型`kAudioUnitSubType_AudioFilePlayer`, 在AudioUnit 里面, 如果我们的输入不是麦克风, 而希望其是一个媒体文件, 当然, 也可以类似于代码仓库中的AudioPlayer项目自行解码, 转换之后将数据输送给RemoteIO Unit播放出来, 但是其实还有一种更简单, 方便的方式. 那就是使用AudioFilePlayer这个 AudioUnit, 可以参考代码仓库中的AUPlayer项目, 

```

需要注意的是, 必须在初始化AUGraph之后, 再去配置AudioFilerPlayer的数据源以及播放范围等属性, 否者就会出现错误,其实数据源还是会调用AudioFile的解码功能, 将媒体文件中的压缩数据解压成为PCM裸数据, 最终再交给AudioFilePlayer Unit进行后续处理.

```


