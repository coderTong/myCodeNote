//
//  Cocopads常用命令.h
//  Good_Code
//
//  Created by wutong on 16/1/2.
//  Copyright © 2016年 wutong. All rights reserved.
//

#ifndef Cocopads_____h
#define Cocopads_____h



/**
 
 // 安装 cocoapods
 sudo gem install cocoapods
 // 设置 仓库
 pod setup
 
 
 // 查看版本
 pod --version
 
 // 删除 cocoapods
 sudo gem uninstall cocoapods
 
 // 搜素项目
 pod search AFNetworing
 
 
 
 // 给项目新建pods
 pod install
 / 听别人说的下面一句亦可以
 pod install 换成pod install --verbose --no-repo-update
 pod install 换成pod install --verbose --no-repo-update这个命令，前面的命令被墙了
 
 cocoapods在执行  pod install 和pod update时,会默认先更新一次cocopods的spec仓库索引,使用pod install -—no-repo-update参数可以禁止其做索引更新操作
 pod install -—no-repo-update
 pod update -—no-repo-update
 
 
 所以我猜被墙后的命令中的--no也是禁止啥的
 pod install --verbose --no-repo-update

 
 
 
 // 查看ruby 数据源
 gem sources -l
 
 
 // 更改ruby数据源地址
 gem sources --add https://ruby.taobao.org/ --remove http://ruby.taobao.org/
 */






/**
 Podfile.lock 应该保持才本地不应该提交,,因为他会锁定第三方框架的版本, 
 执行pod install不会更新版本,只有 pod update才会更新版本
 
 所以不提交!!!!
 
 
 
 */

#endif /* Cocopads_____h */
