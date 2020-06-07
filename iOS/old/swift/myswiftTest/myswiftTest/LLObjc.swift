////        var imageDatas:[Data] = [];
//////
////        for image in images {
////
////            imageDatas.append(UIImagePNGRepresentation(image)!)
////
////            let tmpImageData:NSData = UIImage.reSizeImageData(image, maxImageSize: 1024, maxSizeWithKB: 1024)! as NSData
////
////
////
////            var path:String = NSHomeDirectory();
////
////            let name = "www.file" + "\(LL_GlobalSingleton.shared().timeStamp ?? 0)" + "_image.jpg";
////            path = path + "/Documents/" + name
////
////            tmpImageData.write(toFile: path , atomically: true)
////
//////            (UIImagePNGRepresentation(image) as! NSData).write(toFile: path , atomically: true)
//////            imageDatas.append(UIImagePNGRepresentation(image)!).
////
////
////
////
////        }
//
////        for i in 0..<imageDatas.count {
////
////            let data = imageDatas[i]
////            let name = "ppppppfile" + "\(LL_GlobalSingleton.shared().timeStamp ?? 0)" + "_image"
////            let fileName = name + ".jpg"
////
////            let path = LL_LocalStorageManager.filePath(name: fileName)
////
////            print(path)
////            let sData:NSData = data as NSData
////            sData.write(to: URL.init(string: path)!, atomically: false)
////
//////            sData.write(toFile: path, atomically: true)
////
////            break
//////            do {
//////
//////
////////                data.write(to: <#T##URL#>)
////////                try data.write(to: URL.init(string: path)!)
//////
//////            } catch _ {
//////
//////            }
////
////
////
////
//////            multipartFormData.append(datas[i], withName: name, fileName: fileName, mimeType: "image/jpg")
////        }
//
//
//
//
//
//
//["DID": "2A42C59B-4729-4818-85AD-1169BDD21FC9-6292-00000717E6F96231",
// "D": ["D": "合同录入",
//       "AID": "9q+SkKKtqDg=",
//       "PLIST": [["PATH": "http://120.78.93.147/img/DATE/20180625/47b7a42bff8b4d75b2eb46aad50f0eab.jpg"],
//                 ["PATH": "http://120.78.93.147/img/DATE/20180625/28990d26a4e14da180da9930401ba3b8.jpg"]]],
// "C": "PostPicInfo", "VS": "v1.0"]
//
//
//
//
//
//
////        imageArray = [UIImage.init(named: "123456"),
////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456"),
//////                      UIImage.init(named: "123456")
////            ] as! [UIImage]
//
//
////        print((UIImagePNGRepresentation(UIImage.init(named: "123456")!) as! NSData).length)
//
////        self.imageArray.append(UIImage.init(named: "lingli_login_temp")!);
