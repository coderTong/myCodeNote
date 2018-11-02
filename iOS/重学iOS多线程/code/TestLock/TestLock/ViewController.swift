//
//  ViewController.swift
//  TestLock
//
//  Created by codew on 10/31/18.
//  Copyright © 2018 codew. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        
//        NSRecursiveLock'
        
        let ppp = NSRecursiveLock.init();
        
        ppp.lock()
        
        
        ppp.unlock();
        // Do any additional setup after loading the view, typically from a nib.
    }


}

