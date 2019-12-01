package com.codertomwu.MyThreadTest;

public class MyThreadMain {

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        thread.setName("tom_TEST");
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 20; i++) {
            System.out.println("Main:" + i);
        }
    }
}
