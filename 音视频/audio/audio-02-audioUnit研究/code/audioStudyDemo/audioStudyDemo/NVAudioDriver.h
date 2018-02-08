//
//  NVAudioDriver.h
//  audioStudyDemo
//
//  Created by codew on 2018/2/7.
//  Copyright © 2018年 codew. All rights reserved.
//

#ifndef NVAudioDriver_h
#define NVAudioDriver_h

#include <stdio.h>
#include <AudioUnit/AudioUnit.h>
#include <AudioToolbox/AudioServices.h>

typedef enum nvmedia_dir{
    
    NVMEDIA_DIR_NONE = 0,
    NVMEDIA_DIR_CAPTURE = 1, // 获取
    NVMEDIA_DIR_PLAYBACK = 2, // 播放
    NVMEDIA_DIR_CAPTURE_PLAYBACK = 3 // 获取和播放
}nvmedia_dir;

typedef OSStatus(* nvmedia_snd_rec_cb) (void * __nullable clientData, UInt32 inNumberFrames, const AudioBufferList * __nullable ioData);
typedef OSStatus(* nvmedia_snd_play_cb) (void * __nullable clientData, AudioBufferList * __nullable ioData);

// 音频流数据结构
typedef struct nvmrdia_snd_stream{
    nvmedia_dir dir;
    
    int rec_id;
    int play_id;
    unsigned clock_rate;
    
    nvmedia_snd_rec_cb __nullable rec_cb;
    nvmedia_snd_play_cb __nullable play_cb;
    void * __nullable user_data;
    
    AudioUnit __nullable voiceUnit;
    AudioStreamBasicDescription streamDesc;
    
    AudioBufferList * __nullable inputBufferList;
    
    Boolean isActive;
    
    
}nvmedia_snd_stream;


int nvmedia_snd_init(void);

int nvmedia_snd_deinit(void);

int nvmedia_snd_open_rec(int index,
                         unsigned clock_rate,
                         nvmedia_snd_rec_cb __nullable rec_cb,
                         void * __nullable user_data,
                         nvmedia_snd_stream * __nullable * __nullable p_snd_strm);

int nvmedia_snd_open_player(int index,
                            unsigned clock_rate,
                            nvmedia_snd_play_cb __nullable plya_cb,
                            void * __nullable user_data,
                            nvmedia_snd_stream * __nullable * __nullable p_snd_strm);

int nvmedia_snd_open(int rec_id,
                     int play_id,
                     unsigned clock_rate,
                     nvmedia_snd_rec_cb __nullable rec_cb,
                     nvmedia_snd_play_cb __nullable play_cb,
                     void * __nullable user_data,
                     nvmedia_snd_stream * __nullable * __nullable p_snd_strm);

int nvmedia_snd_stream_start(nvmedia_snd_stream * __nullable snd_strm);

int nvmedia_snd_stream_stop(nvmedia_snd_stream * __nullable snd_strm);

int nvmedia_snd_stream_close(nvmedia_snd_stream * __nullable snd_strm);


#endif /* NVAudioDriver_h */
