//
//  NVAudioAdaptor.m
//  audioStudyDemo
//
//  Created by codew on 2018/2/8.
//  Copyright © 2018年 codew. All rights reserved.
//

#import "NVAudioAdaptor.h"

OSStatus audioAdaptorWriteAudioData(void *clientData, UInt32 inNumberFrames, const AudioBufferList * __nullable ioData);
OSStatus audioAdaptorReadAudioData(void *clientData, AudioBufferList * ioData);

OSStatus encoderCallback(AudioConverterRef inAudioConverter, UInt32 *ioNumberDatatPackets, AudioBufferList *ioData, AudioStreamPacketDescription **outDataPacketDescription, void *inUserData);
OSStatus decoderCallback(AudioConverterRef inAudioConverter, UInt32 *ioNumberDatatPackets, AudioBufferList *ioData, AudioStreamPacketDescription **outDataPacketDescription, void *inUserData);

@interface NVAudioAdaptor()
{
    nvmedia_snd_stream *_stream;
}


@end

@implementation NVAudioAdaptor

- (instancetype)init
{
    self = [super init];
    
    if (self) {
        
        
    }
    
    return self;
}

- (BOOL)start
{
    memset(&_asbd_target, 0, sizeof(AudioStreamBasicDescription));
    _asbd_target.mFormatID = kAudioFormatMPEG4AAC;
    _asbd_target.mFormatFlags = kMPEG4Object_AAC_Main;
    _asbd_target.mSampleRate = 32000;
    _asbd_target.mChannelsPerFrame = (UInt32)1;
    
    
    if(nvmedia_snd_init() == 0) {
        
        
         OSStatus status = noErr;
        if (nvmedia_snd_open(-1,
                             -1,
                             32000,
                             audioAdaptorWriteAudioData,
                             audioAdaptorReadAudioData,
                             (__bridge void * _Nullable)(self),
                             &_stream) == 0) {
            
            NSLog(@"snd open rec & play ok..");
            memcpy(&_asbd_internal, &_stream->streamDesc, sizeof(AudioStreamBasicDescription));
            
            
            uint32_t size = sizeof(AudioStreamBasicDescription);
            
            AudioFormatGetProperty(kAudioFormatProperty_FormatInfo, 0, NULL, &size, &_asbd_target);
            AudioClassDescription audioClassDes;
            
            memset(&audioClassDes, 0, sizeof(AudioClassDescription));
            
            AudioFormatGetPropertyInfo(kAudioFormatProperty_Encoders, sizeof(_asbd_target.mFormatID), &_asbd_target.mFormatID, &size);
            int encoderCount = size / sizeof(AudioClassDescription);
            
            AudioClassDescription descriptions[encoderCount];
            AudioFormatGetProperty(kAudioFormatProperty_Encoders, sizeof(_asbd_target.mFormatID), &_asbd_target.mFormatID, &size, descriptions);
            for (int pos = 0; pos < encoderCount; pos ++) {
                if (_asbd_target.mFormatID == descriptions[pos].mSubType && descriptions[pos].mManufacturer == kAppleSoftwareAudioCodecManufacturer) {
                    memcpy(&audioClassDes, &descriptions[pos], sizeof(AudioClassDescription));
                    break;
                }
            }
            
            
            status = AudioConverterNewSpecific(&_asbd_internal, &_asbd_target, 1, &audioClassDes, &audioEncoder);
            if (status != noErr) {
                
                [NVSndUtil checkResult:status withMessage:@"AudioConverterNew encoder failed.. .."];
//                 NSLog(@"AudioConverterNew encoder failed.. ..");
            }
            
            size = kAudioConverterQuality_High; // TODO, quality better when not set..
            status = AudioConverterSetProperty(audioEncoder, kAudioConverterCodecQuality, sizeof(size), &size);
            
            if (status != noErr) {
                NSLog(@"AudioConverterSetProperty err: kAudioConverterEncodeBitRate");
                
            }
        }
    
        if(nvmedia_snd_stream_start(_stream) == 0) {
            NSLog(@"snd stream start ok..");
        }
    }
    
    return YES;
}

#pragma mark - AudioUnit callbacks
// TODO
#define PCM_FRAMES_PER_AAC_FRAME 1024
// 1024 * 16bits/8 * 2 channels = 4096
// 1024 * 16bits/8 * 1 channels = 2048
#define PCM_BYTES_PER_AAC_FRAME 2048

/**
 
 我发现AudioUnit是1秒来40-44个数据包左右
 
 void *clientData =====> NVAudioAdaptor
 
 inNumberFrames =====> 本次包中有多少个采样点
 
 ioData->mBuffers[0].mDataByteSize ======> 本次包的字节数
 ioData->mBuffers[0].mNumberChannels ======> 声道数
 */
OSStatus audioAdaptorWriteAudioData(void *clientData, UInt32 inNumberFrames, const AudioBufferList * __nullable ioData) {
 
    NSLog(@"[audioAdaptorWriteAudioData] : ..........");
    
    static int index = 0;
    NVAudioAdaptor * adaptor = (__bridge NVAudioAdaptor *)(clientData);
    nvAudioAdaptorClientData *userData = &(adaptor->_clientData);
    
    NSLog(@"inNumberFrames=++>%zd", inNumberFrames);
    
    if (ioData->mBuffers[0].mDataByteSize > 0) {
        
//        NSLog(@"mNumberChannels: %zd, mDataByteSize: %zd, index: %zd", ioData->mBuffers[0].mNumberChannels,ioData->mBuffers[0].mDataByteSize, index);
        
//        AudioBuffer buffer = ioData->mBuffers[0];
//        int a[] = buffer.mData;
//        for (int i = 0; i < ioData->mBuffers[0].mDataByteSize; i++) {
//
//
////            int data = *(buffer.mData)[i];
//            NSLog(@"====>: %@", buffer);
//        }
        
        
        
        
        if (userData->OUT_PCM_BUFFER_OFFSET > 0) {
            
            if (userData->OUT_PCM_BUFFER_SIZE) {
                
                memcpy(userData->OUT_PCM_BUFFER, userData->OUT_PCM_BUFFER+userData->OUT_PCM_BUFFER_OFFSET, userData->OUT_PCM_BUFFER_SIZE);
            }
            
            userData->OUT_PCM_BUFFER_OFFSET = 0;
        }
        
        if (userData->OUT_PCM_BUFFER_SIZE + ioData->mBuffers[0].mDataByteSize <= PCM_BUFFER_MAX) {
            
            memcpy(userData->OUT_PCM_BUFFER + userData->OUT_PCM_BUFFER_SIZE, ioData->mBuffers[0].mData, ioData->mBuffers[0].mDataByteSize);
            userData->OUT_PCM_BUFFER_SIZE += ioData->mBuffers[0].mDataByteSize;
        } else {
            
            // 大于
        }
    }
    
    
    if (userData->OUT_PCM_BUFFER_SIZE >= PCM_BYTES_PER_AAC_FRAME) {
        
        uint32_t numOutputDataPackets = 1;
        AudioStreamPacketDescription outPacketDesc[numOutputDataPackets];
        AudioBufferList fillBufList;
        fillBufList.mNumberBuffers = 1;
        
        fillBufList.mBuffers[0].mNumberChannels = adaptor->_asbd_target.mChannelsPerFrame;
        fillBufList.mBuffers[0].mDataByteSize = PCM_BYTES_PER_AAC_FRAME;
        fillBufList.mBuffers[0].mData = userData->OUT_PCM_BUFFER + userData->OUT_AAC_BUFFER_SIZE;
        
        OSStatus status = AudioConverterFillComplexBuffer(adaptor->audioEncoder,
                                                          encoderCallback,
                                                          clientData,
                                                          &numOutputDataPackets,
                                                          &fillBufList,
                                                          outPacketDesc);
        
        if (status != noErr) {
            [NVSndUtil checkResult:status withMessage:@"Audio Encoder err: AudioConverterFillComplexBuffer"];
            return status;
        }
        
        if (fillBufList.mBuffers[0].mDataByteSize > 0) {
            
            BOOL isDo = YES;
            if (isDo) {
                
                int adtsHeaderSize = 7;
                
                int outBufferSize = fillBufList.mBuffers[0].mDataByteSize + adtsHeaderSize;
                uint8_t *outBuffer = malloc(outBuffer);
                
                memcpy(&userData->outADTSFixedHeader, &userData->ADTSFixedHeader, sizeof(userData->outADTSFixedHeader));
                memcpy(&userData->outADTSVarHeader, &userData->ADTSVarHeader, sizeof(userData->outADTSVarHeader));
                
                userData->outADTSFixedHeader.ID = 1;
                userData->outADTSFixedHeader.profile = 1;
                userData->outADTSFixedHeader.samplingFrequencyIndex = [NVSndUtil sampleFreqIndxWithSampleRate:8000];
                userData->outADTSFixedHeader.channelConfiguration = 1;
                
                userData->outADTSVarHeader.frameLength = outBufferSize;
                userData->outADTSVarHeader.adtsBufferFullness = 0x7ff;
                
                [NVSndUtil writeADTSFixedHeader:outBuffer andADTSFixedHeader:userData->outADTSFixedHeader];
                [NVSndUtil writeADTSVariableHeader:outBuffer andADTSVariableHeader:userData->outADTSVarHeader];
                
                
                memcpy(outBuffer + adtsHeaderSize, fillBufList.mBuffers[0].mData, fillBufList.mBuffers[0].mDataByteSize);
                
                NSData * aacData = [NSData dataWithBytesNoCopy:outBuffer length:outBufferSize freeWhenDone:YES];
            }
        }
    }
    index++;
    return noErr;
}

OSStatus audioAdaptorReadAudioData(void *clientData, AudioBufferList * ioData)
{
    //NSLog(@"【audioAdaptorReadAudioData】：%s", __func__);
    
    return noErr;
}

OSStatus encoderCallback(AudioConverterRef inAudioConverter, UInt32 *ioNumberDatatPackets, AudioBufferList *ioData, AudioStreamPacketDescription **outDataPacketDescription, void *inUserData)
{
    NSLog(@"%s", __func__);
    
    return noErr;
}
OSStatus decoderCallback(AudioConverterRef inAudioConverter, UInt32 *ioNumberDatatPackets, AudioBufferList *ioData, AudioStreamPacketDescription **outDataPacketDescription, void *inUserData)
{
    NSLog(@"%s", __func__);
    
    return noErr;
}
@end
