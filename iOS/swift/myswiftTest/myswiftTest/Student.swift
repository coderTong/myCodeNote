//
//  Student.swift
//  myswiftTest
//
//  Created by codew n 2018/6/2.
//  Copyright © 2018年 codew. All rights reserved.
//


/**
 
 swift中类的属性有多种
 存储属性: 存储实例的变量和常量
 计算属性: 通过某种方式计算出来的属性
 类属性: 与整个类自身相关的属性
 
 */

import UIKit

@objcMembers class Student: NSObject {

    // 存储属性
    var age : NSNumber = 0
//    var name : String?
    var chineseScore : NSNumber = 0.0
    var mathScore : NSNumber = 0.0
    
    var name : String?
//    var name : String? {
//
//        willSet (n){
//
//            print( "willSet")
//            print(name ?? "willS=")
//
//            print(n ?? "willS=new")
//
//            print( "willSet")
//        }
//
//        didSet (old){
//
//            print("didSet")
//            print(name ?? "old --new")
//            print(old  ?? "old---old")
//            print("didSet")
//
//        }
//    }
    
    
    
    /**
     
     计算属性
     
     计算属性并不存储实际的值, 而是提供一个getter和一个可选setter来间接获取和设置其他属性
     
     计算属性一般只提供getter方法
     如果只提供getter, 而不提供setter, 则该计算属性为只读属性, 并且可以省略get{}
     
     在setter方法中有一个newValue变量, 是系统指定分配的
     */
//    var averageScore : Double {
//        
//        get {
//            
//            return (chineseScore + mathScore) / 2;
//        }
//                
//    }
    
    
    // 类属性
//    static var corseCount : NSInteger = 0
    
    
    
    /**
     
     
     构造函数
     */
    
    override init() {
        name = "new studennt";
        age = 0
    }
    
    
    init(name:String, age : NSNumber) {
        self.name = name;
        self.age = age
    }
    
    
    init (dict : [String : NSObject]){
        
//        name = dict["name"] as! String
//        age = dict["age"] as! Int

        super.init()
//        setValuesForKeys(dict)
        setValuesForKeys(dict)
        
    }
    
    
    // (参数列表)->(返回值类型) 
    func loadRequest(callBack : ()->() ){
        
        
    }
    
    
}
