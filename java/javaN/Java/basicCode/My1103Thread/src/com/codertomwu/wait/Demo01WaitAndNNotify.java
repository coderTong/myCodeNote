package com.codertomwu.wait;

public class Demo01WaitAndNNotify {


    public static void main(String[] args) {

        Object object = new Object();
        // 消费者
        new Thread(){

            @Override
            public void run() {
                synchronized (object){

                    System.out.println("告诉老板包子的种类和数量");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 唤醒之后执行的代码
                    System.out.println("包子做好了， 开吃！！");
                }
            }
        }.start();

        // 生产者老板
        new Thread(){

            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object){

                    System.out.println("老板5秒之后做好包子");
                    // 唤醒。。。
                    object.notify();
                }
            }
        }.start();



    }


}
