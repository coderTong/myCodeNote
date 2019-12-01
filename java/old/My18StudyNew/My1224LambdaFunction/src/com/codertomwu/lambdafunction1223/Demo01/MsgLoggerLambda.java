package com.codertomwu.lambdafunction1223.Demo01;

/**
 * Created by codew on 12/23/18.
 */
public class MsgLoggerLambda {

    public static void main(String[] args) {

        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(2, ()->{

            System.out.println("Lambda 执行");
            return  msgA + msgB + msgC;
        } );
    }

    public static void log(int level, MsgBuilder builder){

        if (level == 1){

            System.out.println(builder.buildMsg());
        }
    }
}
