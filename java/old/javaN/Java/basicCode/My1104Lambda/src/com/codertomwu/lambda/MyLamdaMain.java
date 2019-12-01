package com.codertomwu.lambda;

public class MyLamdaMain {

    public static void main(String[] args) {

        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("新的线程" + Thread.currentThread().getName());
            }
        }).start();

        // Lambda形式

        new Thread(()->{
            System.out.println("Lambda Say Hello"+ Thread.currentThread().getName());
        }).start();

    }
}
