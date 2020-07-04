iOS 对h264硬编码

```

// 1.创建Session
VTCompressionSessionRef EncodingSession;
int width = 480, height = 640;
OSStatus status = VTCompressionSessionCreate(NULL, width, height, kCMVideoCodecType_H264, NULL, NULL, NULL, didCompressH264, (__bridge void *)(self), &EncodingSession);

// 2. 拿着Session 进行参数设置
// 设置实时编码输出（避免延迟）
  VTSessionSetProperty(EncodingSession, kVTCompressionPropertyKey_RealTime, kCFBooleanTrue);
  VTSessionSetProperty(EncodingSession, kVTCompressionPropertyKey_ProfileLevel, kVTProfileLevel_H264_Baseline_AutoLevel);


// 设置关键帧（GOPsize)间隔
 int frameInterval = 10;
 CFNumberRef frameIntervalRef = CFNumberCreate(kCFAllocatorDefault, kCFNumberIntType, &frameInterval);
  VTSessionSetProperty(EncodingSession, kVTCompressionPropertyKey_MaxKeyFrameInterval, frameIntervalRef);

// 设置期望帧率
 int fps = 10;
 CFNumberRef fpsRef = CFNumberCreate(kCFAllocatorDefault, kCFNumberIntType, &fps);
 VTSessionSetProperty(EncodingSession, kVTCompressionPropertyKey_ExpectedFrameRate, fpsRef);

//设置码率，均值，单位是byte
 int bitRate = width * height * 3 * 4 * 8;
 CFNumberRef bitRateRef = CFNumberCreate(kCFAllocatorDefault, kCFNumberSInt32Type, &bitRate);
VTSessionSetProperty(EncodingSession, kVTCompressionPropertyKey_AverageBitRate, bitRateRef);

//设置码率，上限，单位是bps
int bitRateLimit = width * height * 3 * 4;
CFNumberRef bitRateLimitRef = CFNumberCreate(kCFAllocatorDefault, kCFNumberSInt32Type, &bitRateLimit);
VTSessionSetProperty(EncodingSession, kVTCompressionPropertyKey_DataRateLimits, bitRateLimitRef);

// 3. 告诉编码器开始解码(等着喂buffer数据)
VTCompressionSessionPrepareToEncodeFrames(EncodingSession);

// 4.使用AVFoundation框架,采集buffer数据, 然后喂给解码器

```
# 使用AVFoundation框架,采集buffer数据
```
/*
 AVCaptureSession *mCaptureSession; //负责输入和输出设备之间的数据传递
 AVCaptureDeviceInput *mCaptureDeviceInput;//负责从AVCaptureDevice获得输入数据
 AVCaptureVideoDataOutput *mCaptureDeviceOutput; //
 AVCaptureVideoPreviewLayer *mPreviewLayer;
**/


// 1. 创建mCaptureSession负责调度,输入和输出数据
self.mCaptureSession = [[AVCaptureSession  alloc] init];
self.mCaptureSession.sessionPreset = AVCaptureSessionPreset1920x1080; // 采集视频的尺寸, 其实最后取决于那啥,编码器那里的设置



// 2. 创建输入设备
AVCaptureDevice *inputCamera = nil;
NSArray *devices = [AVCaptureDevice  devicesWithMediaType:AVMediaTypeVideo];

 for (AVCaptureDevice *device in devices)
 {
     if ([device position] == AVCaptureDevicePositionBack)
     {
         inputCamera = device;
     }
 }

self.mCaptureDeviceInput = [[AVCaptureDeviceInput alloc] initWithDevice:inputCamera error:nil];
if ([self.mCaptureSession  canAddInput:self.mCaptureDeviceInput]) {

    [self.mCaptureSession  addInput:self.mCaptureDeviceInput];

 }


// 3. 创建输出设备
self.mCaptureDeviceOutput = [[AVCaptureVideoDataOutput  alloc] init];
[self.mCaptureDeviceOutput  setAlwaysDiscardsLateVideoFrames:NO];
[self.mCaptureDeviceOutput  setVideoSettings:[NSDictionary  dictionaryWithObject:[NSNumber  numberWithInt:kCVPixelFormatType_420YpCbCr8BiPlanarFullRange] forKey:(id)kCVPixelBufferPixelFormatTypeKey]];

[self.mCaptureDeviceOutput  setSampleBufferDelegate:self  queue:mCaptureQueue];
if ([self.mCaptureSession  canAddOutput:self.mCaptureDeviceOutput]) {
	 [self.mCaptureSession  addOutput:self.mCaptureDeviceOutput];
 }

// 4. 创建并添加输入输出设备后设置一下方向, 不然好像默认是UpsideDown, 就是颠倒的
AVCaptureConnection *connection = [self.mCaptureDeviceOutput  connectionWithMediaType:AVMediaTypeVideo];

[connection setVideoOrientation:AVCaptureVideoOrientationPortrait];//


//5. 实现输出设备的的代理方法, 接收buffer,喂给编码器
- (void)captureOutput:(AVCaptureOutput *)captureOutput didOutputSampleBuffer:(CMSampleBufferRef)sampleBuffer fromConnection:(AVCaptureConnection *)connection {

  dispatch_sync(mEncodeQueue, ^{

 [self encode:sampleBuffer];

 });

}
```


# 编码器收到buffer后编码

```

- (void) encode:(CMSampleBufferRef )sampleBuffer
{
    CVImageBufferRef imageBuffer = (CVImageBufferRef)CMSampleBufferGetImageBuffer(sampleBuffer);
    // 帧时间，如果不设置会导致时间轴过长。
    CMTime presentationTimeStamp = CMTimeMake(frameID++, 1000);
    VTEncodeInfoFlags flags;
    OSStatus statusCode = VTCompressionSessionEncodeFrame(EncodingSession,
                                                          imageBuffer,
                                                          presentationTimeStamp,
                                                          kCMTimeInvalid,
                                                          NULL, NULL, &flags);
    if (statusCode != noErr) {
        NSLog(@"H264: VTCompressionSessionEncodeFrame failed with %d", (int)statusCode);
        
        VTCompressionSessionInvalidate(EncodingSession);
        CFRelease(EncodingSession);
        EncodingSession = NULL;
        return;
    }
    NSLog(@"H264: VTCompressionSessionEncodeFrame Success");
}

```



# 编码回调函数
```

// 编码完成回调
void didCompressH264(void *outputCallbackRefCon, void *sourceFrameRefCon, OSStatus status, VTEncodeInfoFlags infoFlags, CMSampleBufferRef sampleBuffer) {
    
    
    NSLog(@"didCompressH264 called with status %d infoFlags %d", (int)status, (int)infoFlags);
    if (status != 0) {
        return;
    }
    
    if (!CMSampleBufferDataIsReady(sampleBuffer)) {
        NSLog(@"didCompressH264 data is not ready ");
        return;
    }
    ViewController* encoder = (__bridge ViewController*)outputCallbackRefCon;
    
    bool keyframe = !CFDictionaryContainsKey( (CFArrayGetValueAtIndex(CMSampleBufferGetSampleAttachmentsArray(sampleBuffer, true), 0)), kCMSampleAttachmentKey_NotSync);
    // 判断当前帧是否为关键帧
    // 获取sps & pps数据
    if (keyframe)
    {
        CMFormatDescriptionRef format = CMSampleBufferGetFormatDescription(sampleBuffer);
        size_t sparameterSetSize, sparameterSetCount;
        const uint8_t *sparameterSet;
        OSStatus statusCode = CMVideoFormatDescriptionGetH264ParameterSetAtIndex(format, 0, &sparameterSet, &sparameterSetSize, &sparameterSetCount, 0 );
        if (statusCode == noErr)
        {
            // Found sps and now check for pps
            size_t pparameterSetSize, pparameterSetCount;
            const uint8_t *pparameterSet;
            OSStatus statusCode = CMVideoFormatDescriptionGetH264ParameterSetAtIndex(format, 1, &pparameterSet, &pparameterSetSize, &pparameterSetCount, 0 );
            if (statusCode == noErr)
            {
                // Found pps
                NSData *sps = [NSData dataWithBytes:sparameterSet length:sparameterSetSize];
                NSData *pps = [NSData dataWithBytes:pparameterSet length:pparameterSetSize];
                if (encoder)
                {
                    [encoder gotSpsPps:sps pps:pps];
                }
            }
        }
    }
    
    CMBlockBufferRef dataBuffer = CMSampleBufferGetDataBuffer(sampleBuffer);
    size_t length, totalLength;
    char *dataPointer;
    OSStatus statusCodeRet = CMBlockBufferGetDataPointer(dataBuffer, 0, &length, &totalLength, &dataPointer);
    if (statusCodeRet == noErr) {
        size_t bufferOffset = 0;
        static const int AVCCHeaderLength = 4; // 返回的nalu数据前四个字节不是0001的startcode，而是大端模式的帧长度length
        
        // 循环获取nalu数据
        while (bufferOffset < totalLength - AVCCHeaderLength) {
            uint32_t NALUnitLength = 0;
            // Read the NAL unit length
            memcpy(&NALUnitLength, dataPointer + bufferOffset, AVCCHeaderLength);
            
            // 从大端转系统端
            NALUnitLength = CFSwapInt32BigToHost(NALUnitLength);
            
            NSData* data = [[NSData alloc] initWithBytes:(dataPointer + bufferOffset + AVCCHeaderLength) length:NALUnitLength];
            [encoder gotEncodedData:data isKeyFrame:keyframe];
            
            // Move to the next NAL unit in the block buffer
            bufferOffset += AVCCHeaderLength + NALUnitLength;
        }
    }
}


```