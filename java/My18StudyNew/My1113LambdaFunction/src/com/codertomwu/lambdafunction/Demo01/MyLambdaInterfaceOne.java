package com.codertomwu.lambdafunction.Demo01;

/**
 * Created by codew on 11/13/18.
 */
public class MyLambdaInterfaceOne {

    public static void main(String[] args) {


        test(()->{

            System.out.println("嘿嘿`````");
        });

    }


    private static void test(IMyLambdaTestOne one){

        one.test1();
    }
}
