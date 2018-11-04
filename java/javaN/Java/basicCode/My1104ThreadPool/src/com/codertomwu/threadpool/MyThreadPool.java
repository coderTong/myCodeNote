package com.codertomwu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.5之后提供的
 * java.util.concurrent.Executors
 * Executors 类的静态方法
 *
 * static ExecutorService newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
 *参数： int nThreads: 创建的线程池中包含的线程数量
 * 返回值 ExecutorService接口， 返回的是ExecutorService接口的实现类对象， 我们可以使用ExecutorService接口接收（面向接口编程）
 *
 * java.util.concurrent.ExecutorService:线程池接口
 * 用来从线程池中获取线程,调用start方法, 执行线程任务
 *
 * submit(Runnable task) 提交一个 Runnable 任务用于执行
 *
 * 关闭/销毁线程池的方法
 * void shutdown()  启动一次顺序关闭，执行以前提交的任务，但不接受新任务
 *
 *
 * 线程池的使用步骤
 * 1. 使用线程池的工厂类Executors 里面提供的静态方法newCachedThreadPool() 产生一定数量的线程池
 * 2.创建一个类， 实现Runnable接口， 重写run方法， 设置线程任务
 * 3. 调用ExecutorService中的submit， 传递线程任务（实现类）， 开启线程， 执行run方法
 * 4.效用ExecutorService中的方法shutdown销毁线程（不建议执行）
 * */
public class MyThreadPool {

    public static void main(String[] args) {

//        1. 使用线程池的工厂类Executors 里面提供的静态方法newCachedThreadPool() 产生一定数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);

        //3. 调用ExecutorService中的submit， 传递线程任务（实现类）， 开启线程， 执行run方法
        // 线程池会一直开启， 使用完了线程，会自动把线程归还给线程池， 线程可以继续使用
        es.submit(new MYPoolRunnable());//pool-1-thread-1执行
        es.submit(new MYPoolRunnable());//pool-1-thread-2执行
        es.submit(new MYPoolRunnable());//pool-1-thread-1执行


        // 一执行线程池就没了， 不建议执行
        es.shutdown();
    }
}
