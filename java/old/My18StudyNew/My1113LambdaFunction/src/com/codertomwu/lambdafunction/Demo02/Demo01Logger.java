package com.codertomwu.lambdafunction.Demo02;

/**
 * Created by codew on 11/13/18.
 */
public class Demo01Logger {

    public static void main(String[] args) {

        String msgA = "XX类,";
        String msgB = "XX方法,";
        String msgC = "XX错误,";

        log(1, msgA + msgB + msgC);
    }

    public static void log(int level, String msg){

        /**
         * 这段代码存在问题:无论级别是否满足要求，作为 log 方法的第二个参数，三个字符串一定会首先被拼接并传入方
         法内，然后才会进行级别判断。如果级别不符合要求，那么字符串的拼接操作就白做了，存在性能浪费。
         */
        if (level == 1){

            System.out.println(msg);
        }
    }

}
