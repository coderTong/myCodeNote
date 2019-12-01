package com.codertomwu.MyThreadTest;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {

            System.out.println("RunnablClass:"+i);
        }
    }
}
