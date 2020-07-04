//
//  NVSndUtil.h
//  audioStudyDemo
//
//  Created by codew on 2018/2/9.
//  Copyright © 2018年 codew. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreMedia/CoreMedia.h>

#define PCM_BUFFER_MAX 102400
#define AAC_BUFFER_MAX 102400

typedef struct {
    uint8_t headerSize;
    uint8_t ID;
    uint8_t profile;
    uint8_t samplingFrequencyIndex;
    uint8_t channelConfiguration;
} NVADTSFixedHeader;

typedef struct {
    uint32_t frameLength;
    uint32_t adtsBufferFullness;
} NVADTSVariableHeader;

typedef struct ADTS_HEADER{
    uint8_t mpegVersion;
    uint8_t hasCRC;
    uint8_t profile;
    uint8_t sampleFreqIndx;
    uint8_t channels;
    uint16_t frameSize;
    uint8_t aacFrameCount;
    
    uint8_t length;
    uint8_t aac_es_config[2];
}ADTS_HEADER;

typedef struct nvAudioAdaptorClientData {
    Byte PCM_BUFFER[PCM_BUFFER_MAX];
    uint32_t PCM_BUFFER_OFFSET;
    uint32_t PCM_BUFFER_SIZE;
    Byte AAC_BUFFER[AAC_BUFFER_MAX];
    uint32_t AAC_BUFFER_SIZE;
    Byte OUT_PCM_BUFFER[PCM_BUFFER_MAX];
    uint32_t OUT_PCM_BUFFER_OFFSET;
    uint32_t OUT_PCM_BUFFER_SIZE;
    Byte OUT_AAC_BUFFER[AAC_BUFFER_MAX];
    uint32_t OUT_AAC_BUFFER_SIZE;
    AudioStreamPacketDescription packetDesc;
    NVADTSFixedHeader ADTSFixedHeader;
    NVADTSVariableHeader ADTSVarHeader;
    NVADTSFixedHeader outADTSFixedHeader;
    NVADTSVariableHeader outADTSVarHeader;
}nvAudioAdaptorClientData;


@interface NVSndUtil : NSObject

+(void)checkResult:(OSStatus)result withMessage:(NSString *)message;

+ (uint8_t)sampleFreqIndxWithSampleRate:(uint32_t)sampleRate;

+(BOOL)writeADTSFixedHeader:(uint8_t *)buffer andADTSFixedHeader:(NVADTSFixedHeader)header;

+(BOOL)writeADTSVariableHeader:(uint8_t *)buffer andADTSVariableHeader:(NVADTSVariableHeader)header;
@end
