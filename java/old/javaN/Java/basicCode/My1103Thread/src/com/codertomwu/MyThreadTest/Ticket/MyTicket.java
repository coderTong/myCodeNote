package com.codertomwu.MyThreadTest.Ticket;

public class MyTicket implements Runnable {

    private static int ticket = 100;


    public synchronized void synMethod(){


    }


    @Override
    public void run() {

        while (true){

            synchronized (this){

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


        }
    }
}
