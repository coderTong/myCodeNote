package com.codertomwu.lambd2.Demo2;

public class Demo2Main {

    public static void main(String[] args) {


//        int result =

        mysum(20,30, (int a, int b)->{
            return a + b;
        });

        mysum(20,230,(a,b)->a+b);
    }


    public static void  mysum(int a, int b, DemoCalulator calulator){

        int sum = calulator.calc(a, b);
        System.out.println(sum);
    }
}
