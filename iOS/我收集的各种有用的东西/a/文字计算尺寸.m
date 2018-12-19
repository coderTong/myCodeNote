

CGSize maxSize = CGSizeMake(cW, MAXFLOAT);
CGRect expectedFrame = [text boundingRectWithSize:maxSize
                                          options:NSStringDrawingUsesLineFragmentOrigin
                                       attributes:@{NSFontAttributeName:[UIFont systemFontOfSize:font]}
                        context:nil];
