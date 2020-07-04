//
//  NVSndUtil.m
//  audioStudyDemo
//
//  Created by codew on 2018/2/9.
//  Copyright © 2018年 codew. All rights reserved.
//

#import "NVSndUtil.h"

@implementation NVSndUtil

+(void)checkResult:(OSStatus)result withMessage:(NSString *)message {
    char resultString[5];
    UInt32 swappedResult = CFSwapInt32HostToBig (result);
    bcopy (&swappedResult, resultString, 4);
    
    NSString * str = [NSString stringWithUTF8String:resultString];
    resultString[4] = '\0';
    
//    NSString * str = [NSString stringWithUTF8String:resultString];
    NSLog(@"status:%s,\tcode:%zd,\tmessage:%@", resultString, result, message);
}

+ (uint8_t)sampleFreqIndxWithSampleRate:(uint32_t)sampleRate
{
    // 默认设置成8000HZ~
    uint8_t sampleFreqInd = 11;
    switch (sampleRate) {
        case 96000:
        {
            sampleFreqInd = 0;
            break;
        }
        case 88200:
        {
            sampleFreqInd = 1;
            break;
        }
        case 64000:
        {
            sampleFreqInd = 2;
            break;
        }
        case 48000:
        {
            sampleFreqInd = 3;
            break;
        }
        case 44100:
        {
            sampleFreqInd = 4;
            break;
        }
        case 32000:
        {
            sampleFreqInd = 5;
            break;
        }
        case 24000:
        {
            sampleFreqInd = 6;
            break;
        }
        case 22050:
        {
            sampleFreqInd = 7;
            break;
        }
        case 16000:
        {
            sampleFreqInd = 8;
            break;
        }
        case 12000:
        {
            sampleFreqInd = 9;
            break;
        }
        case 11025:
        {
            sampleFreqInd = 10;
            break;
        }
        case 8000:
        {
            sampleFreqInd = 11;
            break;
        }
        case 7350:
        {
            sampleFreqInd = 12;
            break;
        }
            
        default:
            break;
    }
    
    return sampleFreqInd;
}

+(BOOL)writeADTSFixedHeader:(uint8_t *)buffer andADTSFixedHeader:(NVADTSFixedHeader)header {
    buffer[0] = 0xff;
    buffer[1] = 0xf1;
    if(header.headerSize == 9) {
        buffer[1] &= 0xfe;
    }
    if(header.ID == 1) {
        buffer[1] |= 0x08;
    }
    buffer[2] = header.profile << 6;
    buffer[2] |= header.samplingFrequencyIndex << 2;
    buffer[2] |= (header.channelConfiguration >> 2) & 0x01;
    buffer[3] = header.channelConfiguration << 6;
    
    return YES;
}

+(BOOL)writeADTSVariableHeader:(uint8_t *)buffer andADTSVariableHeader:(NVADTSVariableHeader)header {
    buffer[3] = (buffer[3] & 0xfc) | ((header.frameLength >> 11) & 0x03);
    buffer[4] = (header.frameLength >> 3) & 0xff;
    buffer[5] = (buffer[5] & 0x1f) | ((header.frameLength << 5) & 0xe0);
    buffer[5] |= (header.adtsBufferFullness >> 6) & 0x1f;
    buffer[6] = (header.adtsBufferFullness & 0x3f) << 2;
    return YES;
}
@end
