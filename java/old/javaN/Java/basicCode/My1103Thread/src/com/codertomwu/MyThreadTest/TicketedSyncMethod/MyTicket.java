package com.codertomwu.MyThreadTest.TicketedSyncMethod;

public class MyTicket implements Runnable {

    private static int ticket = 100;


    public synchronized void synMethod(){

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
    }

    public static synchronized void synMethod2(){

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
    }


    @Override
    public void run() {

        System.out.println("黑恶");
        synMethod2();
    }
}
