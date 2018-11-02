package com.codertomwu.my1031.MYDate;

import java.util.Date;

public class MyDateTest {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

//        Date date1 = new Date(1540945016000L);// 传递毫秒值,  必须要加L。。。
        Date date1 = new Date(1540945827610L);// 传递毫秒值,  必须要加L。。。
        System.out.println(date1);
        System.out.println(date.getTime());

    }

}
