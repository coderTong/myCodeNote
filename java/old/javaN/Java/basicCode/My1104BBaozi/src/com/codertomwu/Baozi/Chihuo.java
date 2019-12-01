package com.codertomwu.Baozi;

public class Chihuo extends Thread {

    private Baozi baozi;

    public Chihuo(Baozi baozi){

        this.baozi = baozi;
    }

    @Override
    public void run() {
        System.out.println("");

        while (true){

            synchronized (baozi){

                if (baozi.flag == false){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 被唤醒之后的代码
                System.out.println("吃货正在吃");
                baozi.flag = false;
                baozi.notify();
                System.out.println("吃货已经把：" + baozi.pi + " " + baozi.xian + "的包子吃完了， 包子铺赶紧补货");
                System.out.println("=======================");

            }
        }
    }




}
