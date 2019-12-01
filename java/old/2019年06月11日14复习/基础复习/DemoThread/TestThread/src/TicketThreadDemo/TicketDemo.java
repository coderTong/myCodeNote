package TicketThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketDemo implements Runnable {


    private int ticket = 100;

    Object lock = new Object();


    Lock lockObj = new ReentrantLock();



    @Override
    public void run() {


        lockMethod();

    }


    /**
     * ============================================================
     * 2019年06月17日14:42:11
     * Lock 锁
     * 超你妈逼..气死我了你麻痹, 超你妈
     *
     * ============================================================
     * */
    public void lockMethod(){

        while (true){

            lockObj.lock();
            if (ticket > 0){

                try {
                    Thread.sleep(100);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }


                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:" + ticket--);

            }

            lockObj.unlock();

        }

    }






    /**
     * ============================================================
     * 2019年06月17日14:35:58
     * 同步方法
     * 一肚子邪火么的
     * ============================================================
     * */
    public synchronized void method(){

        while (true){


            if (ticket > 0){

                try {
                    Thread.sleep(100);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }


                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:" + ticket--);

            }

        }
    }

    /**
     * ============================================================
     *2019年06月17日14:33:28
     * 同步代码块
     * 草他大爷
     * ============================================================
     * */

    public void test2(){

        while (true){


            synchronized (lock){


                if (ticket > 0){


                    try {
                        Thread.sleep(100);

                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖:" + ticket--);

                }
            }



        }

    }



    /**
     * ============================================================
     * 2019年06月17日14:29:58
     * 线程不安全
     * 中午睡觉被吵啊啊啊啊啊啊啊啊啊啊啊啊!
     * ============================================================
     * */

    public void test1(){

        while (true){


            if (ticket > 0){

                try {
                    Thread.sleep(100);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }


                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:" + ticket--);

            }

        }
    }
}
