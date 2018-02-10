//
//  NVAudioAdaptor.h
//  audioStudyDemo
//
//  Created by codew on 2018/2/8.
//  Copyright © 2018年 codew. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <AVFoundation/AVFoundation.h>
#include "NVAudioDriver.h"
#import "NVSndUtil.h"

@interface NVAudioAdaptor : NSObject
{
    nvAudioAdaptorClientData _clientData;
    AudioConverterRef audioEncoder;
    AudioStreamBasicDescription _asbd_target;
    AudioStreamBasicDescription _asbd_internal;
}

- (BOOL)start;

@end
