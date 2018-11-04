package com.codertomwu.threadpool;

public class MYPoolRunnable implements Runnable {


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "执行");
    }
}
