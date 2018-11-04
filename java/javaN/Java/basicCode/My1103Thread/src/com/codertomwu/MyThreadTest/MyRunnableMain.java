package com.codertomwu.MyThreadTest;

public class MyRunnableMain {

    public static void main(String[] args) {
        test2();
        test3();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }


    public static void test3(){

        new Thread(new Runnable(){

            @Override
            public void run() {

            }
        }).start();
    }
    public static void test2(){

        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("imp:" + i);
                }
            }
        }.start();

    }
    public static void test1(){

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
