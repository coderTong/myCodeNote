package com.codertomwu.lambd2.Demo03;

public class Demo3Main {

    public static void main(String[] args) {


        // 省略前
//        new Thread(()->{
//            System.out.println("Lambda Say Hello"+ Thread.currentThread().getName());
//        }).start();

        new Thread(()-> System.out.println("嗨， 省略的lambd， 创建新线程")).start();

    }
}
