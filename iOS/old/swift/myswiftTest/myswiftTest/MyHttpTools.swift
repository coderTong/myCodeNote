//
//  MyHttpTools.swift
//  myswiftTest
//
//  Created by codew on 2018/6/3.
//  Copyright © 2018年 codew. All rights reserved.
//

import UIKit

class MyHttpTools: NSObject {

    
    lazy var array : [String] = {
       () -> [String] in
        return ["1", "2", "kk"]
    }()
    
    
    var callBack : ( (_ jsonData:String)->() )?
    
    func loadData(callBack: @escaping (_ jsonData:String)->()) {
        
        print(array)
        
        self.callBack = callBack;
        
        DispatchQueue.global().async {
            
            print("发送网络请求: \(Thread.current)")
            
            DispatchQueue.main.sync {
                
                print("获得数据, 并且返回: \(Thread.current)")
                
                callBack("jsonData");
            }
            
        }
    }
}
