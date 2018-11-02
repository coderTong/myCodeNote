package com.codertomwu.my1030.Nei;

public class NeiMain {

    public static void main(String[] args) {

        System.out.println("");

        TestBody.Heart heart = new TestBody().new Heart();
        heart.say();

        INiName niName = new INiName() {
            @Override
            public void testN() {

            }
        };

        testN(new INiName() {
            @Override
            public void testN() {

            }
        });

        testN(new TestBody());
    }

    public static void testN(INiName nw){

        System.out.println("进来了。。。。" + nw);
    }
}
