package com.codertomwu.lambdafunction1223.LambdaArg;

/**
 * Created by codew on 12/23/18.
 */
public class LambdaArgClass {

    public static void main(String[] args) {

        startThread(()->{

            System.out.println(" 线程任务执行 ");
            System.out.println(Thread.currentThread());
        });
    }

    private static void startThread(Runnable tastk){

        new Thread(tastk).start();
    }


}
