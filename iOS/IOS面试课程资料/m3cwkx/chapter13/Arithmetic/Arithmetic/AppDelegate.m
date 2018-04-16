//
//  AppDelegate.m
//  Arithmetic
//
//  Created by yangyang38 on 2018/2/8.
//  Copyright © 2018年 weibo. All rights reserved.
//

#import "AppDelegate.h"
#import "ReverseList.h"
#import "MergeSortedList.h"
#import "HashFind.h"
#import "MedianFind.h"
@interface AppDelegate ()

@end

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    
    // 无序数组查找中位数
    int list[10] = {12,3,10,8,6,7,11,13,9};
    // 3 6 7 8 9 10 11 12 13
    //         ^
    int median = findMedian(list, 10);
    printf("the median is %d \n", median);

    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
}


- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}


- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
}


- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}


- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}



//// 字符串反转
//char ch[] = "hello,world";
//char_reverse(ch);
//printf("reverse result is %s \n", ch);

// 单链表反转
//struct Node* head = constructList();
//printList(head);
//printf("---------\n");
//struct Node* newHead = reverseList(head);
//printList(newHead);

//// 有序数组归并
//int a[5] = {1,4,6,7,9};
//int b[8] = {2,3,5,6,8,10,11,12};
//
//// 用于存储归并结果
//int result[13];
//// 归并操作
//mergeList(a, 5, b, 8, result);
//// 打印归并结果
//printf("merge result is ");
//for (int i = 0; i < 13; i++) {
//    printf("%d ", result[i]);
//}


// 查找第一个只出现一次的字符
//char cha[] = "gabaccdeff";
//char fc = findFirstChar(cha);
//printf("this char is %c \n", fc);






@end
