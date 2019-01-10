```
\ud83c\udd70
```



```objc

+(NSString *)replaceUnicode:(NSString*)unicodeStr{

  NSString *tempStr1=[unicodeStr stringByReplacingOccurrencesOfString:@"\\u"withString:@"\\U"];

  NSString *tempStr2=[tempStr1 stringByReplacingOccurrencesOfString:@"\""withString:@"\\\""];

  NSString *tempStr3=[[@"\""  stringByAppendingString:tempStr2]stringByAppendingString:@"\""];

  NSData *tempData=[tempStr3 dataUsingEncoding:NSUTF8StringEncoding];

  // propertyListWithData:options:format:error: instead.

  NSString* returnStr = [NSPropertyListSerialization  propertyListWithData:tempData options:kCFPropertyListImmutable  format:NULL  error:NULL];

// NSString* returnStr =[NSPropertyListSerialization propertyListFromData:tempData

// mutabilityOption:NSPropertyListImmutable

// format:NULL

// errorDescription:NULL];

  return [returnStr stringByReplacingOccurrencesOfString:@"\\r\\n"withString:@"\n"];

}

```
