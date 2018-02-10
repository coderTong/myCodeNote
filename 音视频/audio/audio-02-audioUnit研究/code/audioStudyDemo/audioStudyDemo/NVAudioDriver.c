//
//  NVAudioDriver.c
//  audioStudyDemo
//
//  Created by codew on 2018/2/8.
//  Copyright © 2018年 codew. All rights reserved.
//

#include <stdio.h>
#include "NVAudioDriver.h"

#define MANAGE_AUDIO_SESSION 0
/**
 用于表示一类特定音频组件的类型。
 
 音频组件通常通过搜索找到，然后由音频组件的类型、子类型和制造商的三元组唯一标识。
 */
static AudioComponent voiceUnitComponent = NULL;

static nvmedia_snd_stream * snd_strm_instance = NULL;

#if MANAGE_AUDIO_SESSION
    static boolean_t audio_session_initialized = false;
#endif

void nvmedia_snd_audio_session_interruption(void * userData, uint32_t interruptionState);

static void initializeAudioSession()
{
#if MANAGE_AUDIO_SESSION
    
    if (!audio_session_initialized) {
        
        /**
         AudioSessionInitialize(<#CFRunLoopRef inRunLoop#>, <#CFStringRef inRunLoopMode#>, <#AudioSessionInterruptionListener inInterruptionListener#>, <#void *inClientData#>)
         
         */
        
        AudioSessionInitialize(NULL,
                               kCFRunLoopDefaultMode,
                               ( void(*)(void*,UInt32) )nvmedia_snd_audio_session_interruption,
                               NULL);
        audio_session_initialized = true;
    }

#endif
}


static void startAudioSession(nvmedia_dir dir)
{
//    UInt32 sessionCategory;
//
//    if (dir == NVMEDIA_DIR_CAPTURE) {
//
//        sessionCategory = kAudioSessionCategory_RecordAudio;
//    }
//    else if (dir == NVMEDIA_DIR_PLAYBACK){
//
//        sessionCategory = kAudioSessionCategory_MediaPlayback;
//    }
//    else{
//
//        sessionCategory = kAudioSessionCategory_PlayAndRecord;
//    }
//
//#if MANAGE_AUDIO_SESSION
//
//    AudioSessionSetProperty(kAudioSessionProperty_AudioCategory,
//                        sizeof(sessionCategory),
//                        &sessionCategory);
//
//    AudioSessionSetActive(true);
//#endif
}



static void stopAudioSession()
{
//#if MANAGE_AUDIO_SESSION
//
//    AudioSessionSetActive(false);
//#endif
}

/**
 
 开启或者关闭会话
 
 * Invoked when our audio session is interrupted, or uninterrupted.
 **/
void nvmedia_snd_audio_session_interruption(void *userData, uint32_t interuptionState)
{
    if (interuptionState == kAudioSessionBeginInterruption) {
        
        if (snd_strm_instance && snd_strm_instance->isActive) {
            
            AudioOutputUnitStop(snd_strm_instance->voiceUnit);
        }
        
    }else if (interuptionState == kAudioSessionEndInterruption){
        
        if (snd_strm_instance && snd_strm_instance->isActive) {
            
            startAudioSession(snd_strm_instance->dir);
            
            AudioOutputUnitStart(snd_strm_instance->voiceUnit);
        }
    }
}



static OSStatus NVOutputBusRenderCallack(void                           *inRefCon,
                                         AudioUnitRenderActionFlags     *ioActionFlags,
                                         const AudioTimeStamp           *inTimeStamp,
                                         UInt32                         inBusNumber,
                                         UInt32                         inNumberFrames,
                                         AudioBufferList                *ioData)
{
    nvmedia_snd_stream *snd_strm = (nvmedia_snd_stream *)inRefCon;
    
//    printf("[NVOutputBusRenderCallack]:\n");
    
    return snd_strm->play_cb(snd_strm->user_data, ioData);
}


// 这个是录音?
static OSStatus NVInputBusInputCallback(void *inRefcon,
                                        AudioUnitRenderActionFlags *ioActionFlags,
                                        const AudioTimeStamp *inTimeStamp,
                                        UInt32 inBusNumber,
                                        UInt32 inNumberFrames,
                                        AudioBufferList *ioData)
{
    nvmedia_snd_stream *snd_strm = (nvmedia_snd_stream *)inRefcon;
    
    AudioBufferList *abl = snd_strm->inputBufferList;
    abl->mBuffers[0].mData = NULL;
    abl->mBuffers[0].mDataByteSize = inNumberFrames * snd_strm->streamDesc.mBytesPerFrame;
    
    OSStatus status;
    
    if (ioActionFlags != (AudioUnitRenderActionFlags)0 ) {
        
        status = AudioUnitRender(snd_strm->voiceUnit,
                                 ioActionFlags,
                                 inTimeStamp,
                                 inBusNumber,
                                 inNumberFrames,
                                 abl);
    }
    
    if (status != noErr) {
        
        return -1;
    }
    
    return snd_strm->rec_cb(snd_strm->user_data, inNumberFrames, abl);
}


int nvmedia_snd_init()
{
    
    initializeAudioSession();
    
    AudioComponentDescription desc;
    
    desc.componentType = kAudioUnitType_Output;
    desc.componentSubType = kAudioUnitSubType_VoiceProcessingIO;
    desc.componentManufacturer = kAudioUnitManufacturer_Apple;
    desc.componentFlags = 0;
    desc.componentFlagsMask = 0;
    
    voiceUnitComponent = AudioComponentFindNext(NULL, &desc);
    
    if (voiceUnitComponent == NULL) {
        
        return -1;
    }
    
    return 0;
}


int nvmedia_snd_deinit()

{
    voiceUnitComponent = NULL;
 
    return 0;
}


int nvmedia_snd_open_rec(int index,
                         unsigned clock_rate,
                         nvmedia_snd_rec_cb __nullable rec_cb,
                         void * __nullable user_data,
                         nvmedia_snd_stream * __nullable * __nullable p_snd_strm)
{
    return nvmedia_snd_open(index,
                            -2,
                            clock_rate,
                            rec_cb,
                            NULL,
                            user_data,
                            p_snd_strm);
}


int nvmedia_snd_open_player(int index,
                            unsigned clock_rate,
                            nvmedia_snd_play_cb __nullable plya_cb,
                            void * __nullable user_data,
                            nvmedia_snd_stream * __nullable * __nullable p_snd_strm)
{
    return nvmedia_snd_open(-2,
                            index,
                            clock_rate,
                            NULL,
                            plya_cb,
                            user_data,
                            p_snd_strm);
}

int nvmedia_snd_open(int rec_id,
                     int play_id,
                     unsigned clock_rate,
                     nvmedia_snd_rec_cb __nullable rec_cb,
                     nvmedia_snd_play_cb __nullable play_cb,
                     void * __nullable user_data,
                     nvmedia_snd_stream * __nullable * __nullable p_snd_strm)
{
    OSStatus status;
    
    nvmedia_snd_stream * snd_strm;
    
    snd_strm = malloc(sizeof(nvmedia_snd_stream));
    
    memset(snd_strm, 0, sizeof(nvmedia_snd_stream));
    
    
    snd_strm->rec_id        = rec_id;
    snd_strm->play_id       = play_id;
    snd_strm->clock_rate    = clock_rate;
    snd_strm->rec_cb        = rec_cb;
    snd_strm->play_cb       = play_cb;
    snd_strm->user_data     = user_data;
    snd_strm->isActive      = false;
    
    
    snd_strm->inputBufferList = malloc( sizeof(AudioBufferList) );
    memset(snd_strm->inputBufferList, 0, sizeof(AudioBufferList));
    
    if (rec_id == -1) {
        
        rec_id = 0;
    }
    
    if (play_id == -1) {
        
        play_id = 0;
    }
    
    if (rec_id >= 0 && play_id >= 0) {
        
        snd_strm->dir = NVMEDIA_DIR_CAPTURE_PLAYBACK;
    }
    else if (rec_id >= 0){
        
        snd_strm->dir = NVMEDIA_DIR_CAPTURE;
    }
    else if (play_id >= 0){
        
        snd_strm->dir = NVMEDIA_DIR_PLAYBACK;
    }
    
    status = AudioComponentInstanceNew(voiceUnitComponent, &(snd_strm->voiceUnit));
    
    
    
    if (status != noErr) {
        
        return -1;
    }
    
    UInt32 enable = 1;
    
    AudioUnitElement inputBus = 1;
    AudioUnitElement outputBus = 0;
    
    if (snd_strm->dir & NVMEDIA_DIR_CAPTURE) {
        
        printf("[NVMEDIA_DIR_CAPTURE]: seting.......");
        
        status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                      kAudioOutputUnitProperty_EnableIO,
                                      kAudioUnitScope_Input,
                                      inputBus,
                                      &enable,
                                      sizeof(enable));
        
        if (status != noErr) {
            
            printf("[NVMEDIA_DIR_CAPTURE]: set.......fail\n");
            return -2;
        }
        printf("[NVMEDIA_DIR_CAPTURE]: set.......ok\n");
    }
    
    if (snd_strm->dir & NVMEDIA_DIR_PLAYBACK) {
        
        printf("[NVMEDIA_DIR_PLAYBACK]: seting.......\n");
        enable = 1;
        status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                      kAudioOutputUnitProperty_EnableIO,
                                      kAudioUnitScope_Output,
                                      outputBus,
                                      &enable,
                                      sizeof(enable));
        
        if (status != noErr) {
            printf("[NVMEDIA_DIR_PLAYBACK]: set.......fail\n");
            return -3;
        }
        
        printf("[NVMEDIA_DIR_PLAYBACK]: set.......ok\n");
    }
    
    snd_strm->streamDesc.mSampleRate = clock_rate;
    snd_strm->streamDesc.mFormatID = kAudioFormatLinearPCM;
    snd_strm->streamDesc.mFormatFlags = kLinearPCMFormatFlagIsSignedInteger | kAudioFormatFlagIsPacked;
    
    
    snd_strm->streamDesc.mBitsPerChannel = 16; // 采样精度
    snd_strm->streamDesc.mChannelsPerFrame = 1;// 声道数
    snd_strm->streamDesc.mBytesPerFrame = snd_strm->streamDesc.mBitsPerChannel * snd_strm->streamDesc.mChannelsPerFrame / 8;// 每一个采样点的字节数
    snd_strm->streamDesc.mFramesPerPacket = 1;// 每个数据包有多少个采样点
    snd_strm->streamDesc.mBytesPerPacket = snd_strm->streamDesc.mBytesPerFrame * snd_strm->streamDesc.mFramesPerPacket; // 每个数据包字节数
    
    snd_strm->inputBufferList->mNumberBuffers = 1;
    snd_strm->inputBufferList->mBuffers[0].mNumberChannels = snd_strm->streamDesc.mChannelsPerFrame;
    
    if (snd_strm->dir & NVMEDIA_DIR_CAPTURE) {
        
        status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                      kAudioUnitProperty_StreamFormat,// 数据流格式
                                      kAudioUnitScope_Output, // 输出,也就是手机录音
                                      inputBus,
                                      &(snd_strm->streamDesc),
                                      sizeof(snd_strm->streamDesc));
        
        if (status != noErr) {
            
            return -4;
        }
    }
    
//    startAudioSession(snd_strm->dir);
    
    status = AudioUnitInitialize(snd_strm->voiceUnit);
    
    if (status != noErr) {
        
        return -5;
    }
    
    // 设置音频IO描述 啥声道数,采样精度,采样率啥的====================================================================================
    if (snd_strm->dir & NVMEDIA_DIR_PLAYBACK) {
        
        status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                      kAudioUnitProperty_StreamFormat,
                                      kAudioUnitScope_Input,
                                      outputBus,
                                      &(snd_strm->streamDesc),
                                      sizeof(snd_strm->streamDesc));
        
        if (status != noErr) {
            
            return -6;
        }
    }
    
    // 设置音频数据?IO call back 函数====================================================================================
    AURenderCallbackStruct outputBusRenderCallback;
    outputBusRenderCallback.inputProc = NVOutputBusRenderCallack;
    outputBusRenderCallback.inputProcRefCon = snd_strm;
    
    status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                  kAudioUnitProperty_SetRenderCallback,
                                  kAudioUnitScope_Input,
                                  outputBus,
                                  &outputBusRenderCallback,
                                  sizeof(outputBusRenderCallback));
    
    if (status != noErr) {
        
        return -7;
    }
    
    AURenderCallbackStruct inputBusRenderCallback;
    
    inputBusRenderCallback.inputProc = NVInputBusInputCallback;
    inputBusRenderCallback.inputProcRefCon = snd_strm;
    
    status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                  kAudioOutputUnitProperty_SetInputCallback,
                                  kAudioUnitScope_Output,
                                  inputBus,
                                  &inputBusRenderCallback,
                                  sizeof(inputBusRenderCallback));
    
    if (status != noErr) {
        
        return -8;
    }
    
    // 设置输出最大字节数 输出的最大字节数====================================================================================
    uint32_t maxFramesPerSlice = 1024;
    status = AudioUnitSetProperty(snd_strm->voiceUnit,
                                  kAudioUnitProperty_MaximumFramesPerSlice,
                                  kAudioUnitScope_Global,
                                  outputBus,
                                  &maxFramesPerSlice,
                                  sizeof(uint32_t));
    
    // TODO
    if (status != noErr) {
        
        printf("AudioUnitSetProperty: maxFramesPerSlice failed..\n");
    }
    
    
    *p_snd_strm = snd_strm;
    
    snd_strm_instance = snd_strm;
    return 0;
}

int nvmedia_snd_stream_start(nvmedia_snd_stream * __nullable snd_strm)
{
    
    snd_strm->isActive = true;
    
    startAudioSession(snd_strm->dir);
    
    AudioOutputUnitStart(snd_strm->voiceUnit);
    
    return 0;
}

int nvmedia_snd_stream_stop(nvmedia_snd_stream * __nullable snd_strm)
{
    AudioOutputUnitStop(snd_strm->voiceUnit);
    
    stopAudioSession();
    
    snd_strm->isActive = false;
    
    return 0;
}

int nvmedia_snd_stream_close(nvmedia_snd_stream * __nullable snd_strm)
{
    if (snd_strm->voiceUnit) {
        
        AudioUnitUninitialize(snd_strm->voiceUnit);
        AudioComponentInstanceDispose(snd_strm->voiceUnit);
        
        snd_strm->voiceUnit = NULL;
    }
    
    if (snd_strm->inputBufferList) {
        
        free(snd_strm->inputBufferList);
        snd_strm->inputBufferList = NULL;
        
    }
    
    if (snd_strm) {
        
        free(snd_strm);
        snd_strm = NULL;
    }
    
    snd_strm_instance = NULL;
    
    return 0;
}
