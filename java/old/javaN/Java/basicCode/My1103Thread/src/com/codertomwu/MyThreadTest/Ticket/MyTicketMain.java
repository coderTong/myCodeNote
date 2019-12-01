package com.codertomwu.MyThreadTest.Ticket;

public class MyTicketMain {

    public static void main(String[] args) {

        MyTicket ticket = new MyTicket();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}
