package com.codertomwu.my1031.Calendar;

import java.util.Calendar;

public class MYCalendarMain {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar);


        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        calendar.set(Calendar.MONTH, 0);
        System.out.println(calendar.get(Calendar.MONTH));


        calendar.add(Calendar.YEAR, 1);
        System.out.println(calendar.get(Calendar.YEAR));


    }
}
