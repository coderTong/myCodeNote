  // 获取文件路径

  NSString *path = [[NSBundle  mainBundle] pathForResource:@"music"  ofType:@"json"];

  // 将文件数据化

  NSData *data = [[NSData  alloc] initWithContentsOfFile:path];

  // 对数据进行JSON格式化并返回字典形式

  id json = [NSJSONSerialization  JSONObjectWithData:data options:kNilOptions  error:nil];

 [VS_ModelEDMusic  mj_setupReplacedKeyFromPropertyName:^NSDictionary *{

 return @{

 @"idcn" : @"IDCN",

 @"iden" : @"IDEN",

 };

 }];

  NSArray * modelArr = [VS_ModelEDMusic  mj_objectArrayWithKeyValuesArray:json];

 NSLog(@"");







NSString *path = [[NSBundle  mainBundle] pathForResource:@"a100108"

 ofType:@"mp3"];

  AVAudioPlayer* player= [[AVAudioPlayer  alloc] initWithContentsOfURL:

 [NSURL fileURLWithPath:path]

 error:NULL];

 _aPlayer = player;

 player.delegate = self;

 [player play];
