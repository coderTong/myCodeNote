package com.codertomwu.lambdafunction.Demo03;

/**
 * Created by codew on 11/13/18.
 */
public class Demo03Runnable {

    public static void main(String[] args) {


        startThread(()-> System.out.println("开辟新线程执行任务了?" + Thread.currentThread().getName()));
    }

    public static void startThread(Runnable task){

        new Thread(task).start();
    }
}
