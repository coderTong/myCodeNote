//
//  字典.swift
//  myswiftTest
//
//  Created by codew on 2018/6/15.
//  Copyright © 2018年 codew. All rights reserved.
//

import Foundation

//
//字典
//字典的介绍
//
//字典允许按照某个键来访问元素
//字典是由两部分集合构成的，一个是键（key）集合，一个是值（value）集合
//键集合是不能有重复元素的，而值集合是可以重复的，键和值是成对出现的
//Swift中的字典
//Swift字典类型是Dictionary，也是一个泛型集合
//字典的初始化
//
//Swift中的可变和不可变字典
//使用let修饰的数组是不可变字典
//使用var修饰的数组是可变字典
//// 定义一个可变字典
//var dict1 : [String : NSObject] = [String : NSObject]()
//
//// 定义一个不可变字典
//let dict2 = ["name" : "why", "age" : 18]
//在声明一个Dictionary类型的时候可以使用下面的语句之一
//var dict1: Dictionary<Int, String>
//var dict2: [Int: String]
//声明的字典需要进行初始化才能使用，字典类型往往是在声明的同时进行初始化的
//// 定时字典的同时,进行初始化
//var dict = ["name" : "why", "age" : 18]
//
//// swift中任意对象,通常不使用NSObject,使用AnyObject
//var dict : Dictionary<String, AnyObject>
//dict = ["name" : "why", "age" : 18]
//字典的基本操作
//
//// 添加数据
//dict["height"] = 1.88
//dict["weight"] = 70.0
//dict
//
//// 删除字段
//dict.removeValueForKey("height")
//dict
//
//// 修改字典
//dict["name"] = "lmj"
//dict
//
//// 查询字典
//dict["name"]
//字典的遍历
//
//// 遍历字典中所有的值
//for value in dict.values {
//    print(value)
//}
//// 遍历字典中所有的键
//for key in dict.keys {
//    print(key)
//}
//
//// 遍历所有的键值对
//for (key, value) in dict {
//    print(key)
//    print(value)
//}
//字典的合并
//
//// 字典的合并
//var dict1 = ["name" : "yz", "age" : 20]
//var dict2 = ["height" : 1.87, "phoneNum" : "+86 110"]
//// 字典不可以相加合并
//for (key, value) in dict1 {
//    dict2[key] = value
//}
