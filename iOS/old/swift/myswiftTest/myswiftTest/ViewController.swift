//
//  ViewController.swift
//  myswiftTest
//
//  Created by codew on 2018/5/30.
//  Copyright © 2018年 codew. All rights reserved.
//

import UIKit
import CoreLocation

class ViewController: UIViewController {        
    
    
    func latitudeCenter(array:[CLLocationCoordinate2D]) -> Double {
        
        var latArray:[Double]! =  []
        
        for item in array {
            
            latArray?.append(item.latitude)
            
        }
        
        
        for i in 0..<latArray!.count {
            for j in 0 ..< latArray!.count - 1 - i {
                if latArray![j] > latArray![j + 1] {
                    let temp = latArray![j]
                    latArray![j] = latArray![j + 1]
                    latArray![j + 1] = temp
                }
            }
        }
        
        
//        print(latArray)
        
        let count = (latArray?.count)! - 1
        return (latArray![count] - latArray![0])/2.0 +  latArray[0]
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        var arr:[CLLocationCoordinate2D] = []
        
         arr.append(CLLocationCoordinate2DMake(1.2, 2.1))
        arr.append(CLLocationCoordinate2DMake(4.2, 5.3))
        arr.append(CLLocationCoordinate2DMake(9.1, 2.2))
        arr.append(CLLocationCoordinate2DMake(7.0, 1.5))
        arr.append(CLLocationCoordinate2DMake(2.9, 9.4))
        
        print(latitudeCenter(array: arr))
//        latitudeCenter(array: arr)
        
        
        
        
        let str:NSString? = "e10adc3949ba59abbe56e057f20f883e"
        
        print(str?.uppercased)
        
        
        
        
        
        
//
//        let typeValue:Int = 1
//
//        switch typeValue {
//        case 1:
//            print("1111111")
//        case 2:
//            print("hhhh")
//
//        default: break
//
//        }
        
//        var str :NSString = "139-8980-9340";
//
//
//        let arr = str.components(separatedBy: ";")
//
//
//        print(arr)
//        str = str.replacingOccurrences(of: "-", with: "") as NSString
//
//        print(str)
//
//        str  = [strlstringByReplacingOccurrencesOfString:@"-"withString:@""];
//
//
//        NSLog(@"%@",str);
//
//        结果为：13989809340
        
        
        
        
        
        
        
//        myClassOne();
        
//        kkkk()
//        str.componentsSeparatedByString(";")
        
        
        
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    
    func kkkk() -> [CLLocationCoordinate2D]{
    
        let drawString:NSString = "113.9461624918,22.5936518894258;113.944040704325,22.5859870976428;113.944150866591,22.5804480879936;113.954479790054,22.5806290063821;113.954802596751,22.5861305757934;113.954334077527,22.5884452991872";
        
        guard drawString.range(of: ";").location != NSNotFound else {
    
            return []
        }
        
        let longitudeLatitudeStringArr = drawString.components(separatedBy: ";");
        
        var coordinates = [CLLocationCoordinate2D]()
//        coordinates.append(CLLocationCoordinate2DMake(0, 0));
        
        for longitudeLatitudeString in longitudeLatitudeStringArr {
            
            let longitudeLatitudeNSStr = longitudeLatitudeString as NSString
            guard longitudeLatitudeNSStr.range(of: ",").location != NSNotFound else {
                continue
            }
            
            let pointStringArr = longitudeLatitudeNSStr.components(separatedBy: ",");
            let latitudeStr:NSString = pointStringArr[0] as NSString
            let longitudeStr:NSString = pointStringArr[1] as NSString
            
            coordinates.append(CLLocationCoordinate2DMake(latitudeStr.doubleValue, longitudeStr.doubleValue));
        }
        
        
        
        print(coordinates)
        
        return coordinates
    }
    

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
//        _ = names.count
//        _ = names.count
//        _ = names.count
//        _ = names.count
//
//        print(names)
        
//        var randomStr = ""
//        let string:NSString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
//
//        let len = UInt32(string.length - 4);
//        var lenInt:Int?
//        for _ in 0..<15{
//
//            lenInt = Int(arc4random() % len)
//            randomStr = randomStr + string.substring(with: NSRange(location: lenInt!, length: 1))
//        }
//
//        print(randomStr)
    
//        let ui = ProcessInfo.processInfo.globallyUniqueString;
//
////        NSProcessInfo.pro
////        NSString *udid = [[NSProcessInfo processInfo] globallyUniqueString];
//        print(ui)
    }
    
    
    
    func myClassOne() -> Void {
        
        
//        let stu = Student()
//
//        stu.age = 20;
//        stu.name = "st"
//        stu.chineseScore = 100
//        stu.mathScore = 99
//
//
//        print(stu.averageScore)
//        print(stu.averageScore)
//
//
//        Student.corseCount = 3
//        print(Student.corseCount)
        
        // 2
        let stu = Student(name: "su", age: 19)
        print(stu.age)
        
        
        // 3
//        let dict = ["name" : "why", "age" : 19] as [String : Any];
//        let stu3 = Student(dict: dict as! [String : NSObject]);
//        print(stu3.age)
        
        
        let dict2 = ["name" : "why", "age" : 19, "chineseScore" : 90, "mathScore" : 100] as [String : Any];
        let stu4 = Student(dict: dict2 as! [String : NSObject]);
        print(stu4.age)
    }
    
    
    
    
    
    
    
    
    
    
    
    
    func myMethodTest() -> () {
        
        
        //        self.myClassOptionalTest();
        
        myFunctionTest1();
        
        let str1 = ftest2();
        print(str1);
        
        
        let sum = sumo(num1: 22, num2: 33);
        print(sum)
        
        
        let sum2 = sumt(none: 3, ntwo: 3, nthree: 2)
        print(sum2)
        
        
        let sum3 = sumt(cone: 3, ctwo: 3, cthree: 3)
        print(sum3)
        
        
        let coffee = makeCoffee();
        let coffee2 = makeCoffee(type: "卡布奇诺")
        print(coffee)
        print(coffee2)
        let ss = sumd(numbers: 100.0, 20.0, 30.9)
        print(ss)
        
        
        
        var a = 10
        var b = 22;
        
        
        swap2(a: &a, b: &b);
        print("a:\(a), b:\(b)");
    }
    
    
    
    // 函数
    
    // 值传递和指针传递
    
    func swap2( a :  inout Int,  b : inout Int) -> () {
        
        let temp = a
        a = b
        b = temp
        print("a:\(a), b:\(b)");
    }
    
    // 参数写var是不行了的
//    func swap2(var a : Int, var b : Int) {
//
////        var temp = a;
//        a += 1;
//        b += 1;
//
//
//        print("a:\(a), b:\(b)");
//
//    }
    
    // 可变参数
    func sumd(numbers: Double...) -> Double {
        
        var total : Double = 0;
        for number in numbers {
            
            total += number
        }
        
        return total;
    }
    
    
    // 默认参数
    func makeCoffee(type : String = "拿铁") -> String {
        
        return "制作一杯\(type)咖啡"
    }
    
    // 外部参数
    func sumt(none num1 : Int, ntwo num2 : Int , nthree num3 : Int) -> Int {
        
        return num1 + num2 + num3;
    }
    
    func sumt(cone num1 : Int, ctwo num2 : Int , cthree num3 : Int) -> Int {
        
        return num1 * num2 * num3;
    }
    
    
    
    // 有返回值有参数
    func sumo(num1:Int , num2 : Int) -> Int {
        
        return num1 + num2;
    }
    
    // 没有参数, 有返回值
    func ftest2() -> String {
        
        return "吃了吗您勒";
    }
    
    func myFunctionTest1() -> Void {
        
        print("hi")
    }
    
    
    // 可选类型
    
    func myClassOptionalTest(){
        
        var name : Optional<String> = nil;
        name = "ccc";
        print(name)
        
        var na2 : String? = nil;
//        na2 = "bbb"
        print(na2 ?? "cc")
        
        
        var testStr : Optional<String> = nil

        // 如果可选类型的值为nil, 强解包会报错
        //        testStr = "test"
//        print(testStr!)
        
        // 正确写法
        if testStr != nil{
            print(testStr!)
        }
        
        testStr = "gg"
        if let str = testStr{
            print(str)
        }
        
        
        // 使用场景
        
        let url : NSURL? = NSURL(string: "www.codertomwu.com");
        if let tempUrl = url {
            let  request = NSURLRequest(url: tempUrl as URL);
            print("----")
            
        }
    }
    
    func myYTest(){
        
        let error = (404, "Not Found");
        print(error.0)
        print(error.1)
        
        
        let error2 = (errorCode:404, errorInfo:"not Found")
        print(error2.errorCode)
        print(error2.errorInfo)
        
        let (errorCode2, errorInfo3) = (402, "cccc")
        print(errorCode2)
        print(errorInfo3)
    }
    
    
    func myDicTest(){
        
        // 可变字典
        var dict1 : [String : NSObject] = [String : NSObject]()
        dict1 = ["name" : "yo", "age" : 18] as! [String : NSObject]
        print(dict1)
        // 不可变字典
        let dict2 = ["name" : "hh", "age" : 19] as [String : Any]
        print(dict2)
        
        // 声明
        var dict3 : Dictionary<Int, String>
        var dict4 : [Int : String]
        
        
        // 声明后需要初始化才能使用
        var dict5 = ["name" : "why", "age" : 18] as [String : Any];
        
        dict5["cc"] = "tongren"
        dict5["uo"] = 10
        print(dict5)
        dict5.removeValue(forKey: "uo")
        dict5["cc"] = "yuping"
        print(dict5)
        
        
        // 遍历字典
        for value in dict5.values {
            print(value)
        }
        
        for key in dict5.keys {
            
            print(key)
        }
        
        
        for (key,value) in dict5 {
            
            print(key, "+", value)
//            print()
        }
        
        
        // 字典的合并
        
        var dict6 = ["name" : "zjl", "age" : 20] as [String : Any];
        var dict7 = ["height" : 1.87, "phoneNum" : "+86 110"] as [String : Any]
        
        // 字典不可以相加
        for (key, value) in dict6 {
            
            dict7[key] = value
        }
        print(dict7)
    }
    
    func myArrTest() {
        
        
        // 可变数组
        var mutArr : [String] = [String]();
        var mutArr2 : [String] = [String]();
        mutArr2.append("aa");
        mutArr2.append("bb");
//        mutArr.append(mutArr2)
//        print(mutArr2)
        
        // 不可变数组
        let aar2 : [NSObject] = ["hi" as NSObject, 19 as NSObject];
//        print(aar2)
        
        
        //
        var stuArr1 : Array<String>
        var stuArr2 : [String]
        stuArr1 = ["aa"]
        stuArr2 = ["cc"]
        stuArr1.append("ss")
        stuArr2.append("23")
        
        
        // 直接进行初始化
        var arr3 = ["swift"];
        var arr4 = ["cc"];
        arr3.append("bb")
        arr4.append("gg")
        print(arr3)
        print(arr4)
        
        
        for i in 0..<arr4.count {
            print(arr4[i])
        }
        
        for item in arr4 {
            print(item)
        }
        
        // 同类型的数组可以合并
        var arr5 = ["a", "b", "c"]
        var arr6 = ["fd", "g", "ss"];
        var arr7 = arr5 + arr6;
        print(arr7)
        
        
    }
    
    
    func myStrTest() {
        
//        var str = "hello, swift, 你好吗,我来了";
//
//        for c in str.characters {
//
//            print(c)
//        }
        
        
//        let str1 = "jhello"
//        let str2 = "World"
//        let str3 = str1 + " " + str2
//
//        print(str3)
        
        
//        let name = "why"
//        let age = 18
//
//        let info = "my name is \(name), my age is \(age)"
//
//        print(info)
        
        
//        let min = 3
//        let second = 4
////        let time = String(format: "%02d:%02d", arguments:[min, second]);
//        let time = String(format: "%02d:%02d", min, second);
//        print(time)
        
        
        
        
        let myStr = "www.codertomwu.com";
        let subStr = (myStr as NSString).substring(from: 4);
        let tmpStr = (myStr as NSString).substring(to: 4);
        let su2 =  (myStr as NSString).substring(with: NSRange(location: 4, length: 5))
        print(su2)
    }
    
    
    func myForTest() {
        
        // 传统写法 swift3 已经移除
        
//        for (var i = 0; i < 10; i++){
//
//            print(i)
//        }
        
        
//        let arr : NSArray = ["1", "2"];
//
//        for item in arr {
//            print(item)
//        }
        
//        for i in 0..<10{
//            print(i)
//        }
        
//        for i in 0...100{
//            print(i)
//        }
        
        
//        for _ in 0..<10{
//            print("hello")
//        }
        
        
//        var a = 0
//        while a < 10 {
//            print(a)
//            a += 1;
//        }
        
        
//        var b = 0;
//        repeat {
//            print(b)
//            b += 1;
//        }while b < 20
        
        
        
    }
    
    
    func mySwichTest() -> Void {
        
        
        
        //        let sex = 0;
        //
        //        switch sex {
        //        case 0, 1:
        //
        //            print("正常人")
        ////            fallthrough;
        //        default:
        //
        //            print("性别未知..")
        //        }
        
        //        let sex = 3.14;
        //
        //        switch sex {
        //        case 3.14:
        //
        //            print("pi")
        //        //            fallthrough;
        //        default:
        //
        //            print("性别未知..")
        //        }
        
        
        //        let m = 5
        //        let n = 10
        //        var result = 0
        //
        //        let opration = "+"
        //
        //        switch opration {
        //        case "+":
        //            result = m + n;
        //            print("reslut:", result, opration, "哈哈");
        //        case "-":
        //            result = m + n;
        //            print("reslut: %zd", result);
        //        case "*":
        //            result = m + n;
        //            print("reslut: %zd", result);
        //        case "/":
        //            result = m + n;
        //            print("reslut: %zd", result);
        //        default:
        //            print("输入错误")
        //        }
        
        
        
        
        let score = -88
        
        switch score {
        case 0..<60:
            print("不及格")
        case 60..<80:
            print("及格")
        case 80..<90:
            print("良好")
        case 90..<100:
            print("优秀")
        case 100:
            print("满分")
        default:
            print("分数有误")
        }
    }


}

