//
//  元祖.swift
//  myswiftTest
//
//  Created by codew on 2018/6/15.
//  Copyright © 2018年 codew. All rights reserved.
//

import Foundation



//元祖
//元祖的介绍
//
//元组是Swift中特有的,OC中并没有相关类型
//它是什么呢?
//它是一种数据结构，在数学中应用广泛
//类似于数组或者字典
//可以用于定义一组数据
//组成元组类型的数据可以称为“元素”
//元祖的定义
//
//元祖的常见写法
//// 使用元祖描述一个人的信息
//("1001", "张三", 30, 90)
//// 给元素加上元素名称,之后可以通过元素名称访问元素
//(id:"1001", name:"张三", english_score:30, chinese_score:90)
//元祖的简单使用
//
//用元组来描述一个HTTP的错误信息
//// 元祖:HTTP错误
//// let array = [404, "Not Found"]
//// 写法一:
//let error = (404, "Not Found")
//print(error.0)
//print(error.1)
//
//// 写法二:
//let error = (errorCode : 404, errorInfo : "Not Found")
//print(error.errorCode)
//print(error.errorInfo)
//
//// 写法三:
//let (errorCode, errorIno) = (404, "Not Found")
//print(errorCode)
//print(errorIno)
