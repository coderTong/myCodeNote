package com.codertomwu.lambdafunction.Demo02;

/**
 * Created by codew on 11/13/18.
 */
public class Demo02LoggerLambda {

    public static void main(String[] args) {

        String msgA = "XX类,";
        String msgB = "XX方法,";
        String msgC = "XX错误,";

//        log(1, () -> msgA + msgB + msgC);

        log(2,()->{

            System.out.println("Lambda执行了嘛?");

            return msgA + msgB + msgC;
        });
    }


    public static void log(int leve1, MessageBuilder builder){

        if (leve1 == 1){

            System.out.println(builder.builderMessage());
        }
    }
}
