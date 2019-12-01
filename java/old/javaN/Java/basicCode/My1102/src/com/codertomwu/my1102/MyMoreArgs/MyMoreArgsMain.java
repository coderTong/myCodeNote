package com.codertomwu.my1102.MyMoreArgs;

public class MyMoreArgsMain {

    public static void main(String[] args) {

        ts2("ss","sss");
    }

    public static void ts1(String[] args){

    }

    public static void ts2(String... args){

        System.out.println(args);
    }

    public static void ts3(Object...obj){

    }
}
