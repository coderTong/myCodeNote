package TicketThreadDemo;

public class TicketDemoMain {

    public static void main(String[] args) {

        TicketDemo ticketDemo = new TicketDemo();

        Thread t1 = new Thread(ticketDemo, "窗口1");
        Thread t2 = new Thread(ticketDemo, "窗口2");
        Thread t3 = new Thread(ticketDemo, "窗口3");

        // 同时卖票
        t1.start();
        t2.start();
        t3.start();


    }





}
