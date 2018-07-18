//
//  懒加载.swift
//  myswiftTest
//
//  Created by codew on 2018/6/15.
//  Copyright © 2018年 codew. All rights reserved.
//

import Foundation

class lazyClass: NSObject {
    
    lazy var names : [String] = {
        
        print("------")
        
        return ["why", "yz", "lmj"]
    }()

    
}

