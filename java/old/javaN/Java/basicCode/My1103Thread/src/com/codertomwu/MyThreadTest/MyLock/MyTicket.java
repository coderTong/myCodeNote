package com.codertomwu.MyThreadTest.MyLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTicket implements Runnable {

    private static int ticket = 100;


    Lock lock = new ReentrantLock();

    public void synMethod2(){
        lock.lock();
        while (true){

            if (ticket > 0){

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---->正在卖第：" + ticket + "张票");
                ticket--;
            }else {

                break;
            }
        }
        lock.unlock();
    }


    @Override
    public void run() {

        synMethod2();
    }
}
