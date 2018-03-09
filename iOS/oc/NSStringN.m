/private/var/mobile/Containers/Data/Application/B830-DEAEB7071D98/tmp//deviceVideoEventNVT/23232/Video/sdsdsd/sdsdsd.zip
/private/var/mobile/Containers/Data/Application/B830-DEAEB7071D98/tmp//deviceVideoEventNVT/23232/Video/sdsdsd
[replacedStr stringByDeletingLastPathComponent]


// 拿testName
NSString *str2 = @"Users/CentralPerk/Desktop/testName.txt";
str2 = [str2 stringByDeletingPathExtension];
str2 = [str2 lastPathComponent];
NSLog(@"%@",str2);

// NSString *str2 = @"Users/CentralPerk/Desktop/testName---->
// NSString *str2 = @"Users/CentralPerk/Desktop/testName.NVT3
NSString *str2 = @"Users/CentralPerk/Desktop/testName";
str2 = [str2 stringByAppendingPathExtension:@"NVT3"]
    NSLog(@"%@", str2);



// 替换
NSString*str =@"12345678";

NSString*replacedStr = [str stringByReplacingOccurrencesOfString:@"345"withString:@"想要替换成的字符串"];

NSLog(@"replacedStr ==== %@", replacedStr);

