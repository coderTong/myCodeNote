package com.codertomwu.my1030.Nei;

public class MyOuterr {


    public void test() {

        // 不写也是有效final
        int num = 10;
//        num = 20; // 这样就错了， 不能变
//        final int num = 10; // 写了更保险

        class MyInner{

            public void testInner(){

                System.out.println(num);
            }
        }

    }
}
