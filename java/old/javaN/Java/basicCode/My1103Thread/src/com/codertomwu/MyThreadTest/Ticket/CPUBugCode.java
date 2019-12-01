package com.codertomwu.MyThreadTest.Ticket;

public class CPUBugCode {


}

//
//package com.codertomwu.MyThreadTest.Ticket;
//
//public class MyTicket implements Runnable {
//
//    private static int ticket = 100;
//
//
//    @Override
//    public void run() {
//
//        while (true){
//
//            if (ticket > 0){
//
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "---->正在卖第：" + ticket + "张票");
//                ticket--;
//            }
//        }
//    }
//}



// ======



//package com.codertomwu.MyThreadTest.Ticket;
//
//public class MyTicketMain {
//
//    public static void main(String[] args) {
//
//        MyTicket ticket = new MyTicket();
//
//        Thread t1 = new Thread(ticket);
//        Thread t2 = new Thread(ticket);
//        Thread t3 = new Thread(ticket);
//
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}


