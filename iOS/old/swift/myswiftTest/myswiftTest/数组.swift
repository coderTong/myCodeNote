//
//  数组.swift
//  myswiftTest
//
//  Created by codew on 2018/6/15.
//  Copyright © 2018年 codew. All rights reserved.
//

import Foundation

// 定义一个可变数组,必须初始化才能使用
var array1 : [String] = [String]()

// 定义一个不可变数组
//let array2 : [NSObject] = ["why" as NSObject, 18]
//在声明一个Array类型的时候可以使用下列的语句之一
//var stuArray1:Array<String>
//var stuArray2: [String]
// 声明的数组需要进行初始化才能使用，数组类型往往是在声明的同时进行初始化的
// 定义时直接初始化
//var array = ["why", "lnj", "lmj"]

// 先定义,后初始化
//var array : Array<String>
//array = ["why", "lnj", "lmj"]






//// 遍历数组
//for i in 0..<array.count {
//    print(array[i])
//}
//
//// forin方式
//for item in array {
//    print(item)
//}
//
//// 设置遍历的区间
//for item in array[0..<2] {
//    print(item)
//}


//
//数组的合并
//
//// 数组合并
//// 注意:只有相同类型的数组才能合并
//var array = ["why", "lmj","lnj"]
//var array1 = ["yz", "wsz"]
//var array2 = array + array1;
//
//// 不建议一个数组中存放多种类型的数据
//var array3 = [2, 3, "why"]
//var array4 = ["yz", 23]
//array3 + array4
