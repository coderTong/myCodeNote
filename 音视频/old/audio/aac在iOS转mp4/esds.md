

```

typedef esdsStruct{

uint8_t tag;

<不定长，最长4字节> size;

uint8_t[size] data;

}esdsStruct；

```
各层的起始标签如下：
```

1.  #define MP4ESDescrTag                   0x03  
2.  #define MP4DecConfigDescrTag            0x04  
3.  #define MP4DecSpecificDescrTag          0x05

```




```

SampleDescriptionBox: stsd
    AudioSampleEntry: mp4a / ac-3 / ec-3 
         ESDescriptorBox: esds
		SLConfigDescriptor
         	DecoderConfigDescriptor
			AudioSpecificConfig


SampleDescriptionBox: stsd
	VisualSampleEntry: avc1/ hvc1 / mp4v
		AvcConfigurationBox:	avcC

```