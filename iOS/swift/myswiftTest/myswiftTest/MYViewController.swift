//
//  MYViewController.swift
//  myswiftTest
//
//  Created by codew on 2018/6/3.
//  Copyright © 2018年 codew. All rights reserved.
//

import UIKit

class MYViewController: UIViewController {

    var httptools: MyHttpTools = MyHttpTools()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.view.backgroundColor = UIColor.red
        mySwiftBlock()
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func mySwiftBlock() {
        
        // 解决循环引用方式一
//        weak var weakSelf = self
//
//        httptools.loadData { (string) in
//
//            print(string)
//
//            // ?如果前面的没有值后面的都不执行
//            weakSelf?.view.backgroundColor = UIColor.blue
//        }
        
        // 解决循环引用方式二
//        weak var weakSelf = self
        
//        httptools.loadData {[weak self] (string) in
//
//            print(string)
//
//            // ?如果前面的没有值后面的都不执行
//            self?.view.backgroundColor = UIColor.blue
//        }
        
        
        
        
        // 解决循环引用方式三
        //        weak var weakSelf = self
        // 这样写得话说下面的self一定有值, 所以下面就不需要用?, 但是这样很危险
        httptools.loadData {[unowned self] (string) in
            
            print(string)
            
            // ?如果前面的没有值后面的都不执行
            self.view.backgroundColor = UIColor.yellow
        }
        
        httptools.loadData() {[unowned self] (string) in
            
            print(string)
            
            // ?如果前面的没有值后面的都不执行
            self.view.backgroundColor = UIColor.yellow
        }
        
        
        httptools.loadData (callBack: {[unowned self] (string) in
            
            print(string)
            
            // ?如果前面的没有值后面的都不执行
            self.view.backgroundColor = UIColor.yellow
        })
    }
    
    
    deinit {
        
        print("挂了~.....")
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
