package com.codertomwu.MyThreadTest;

public class MyThread  extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {


            try {
                this.sleep(1000);// 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run:" + i);
        }
        
    }
}
