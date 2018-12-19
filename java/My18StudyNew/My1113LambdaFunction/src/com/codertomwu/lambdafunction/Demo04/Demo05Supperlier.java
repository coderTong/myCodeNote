package com.codertomwu.lambdafunction.Demo04;

import java.util.function.Supplier;

/**
 * Created by codew on 11/13/18.
 */


/*
    常用的函数式接口
    java.util.function.Supplier<T>接口仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。

    Supplier<T>接口被称之为生产型接口,指定接口的泛型是什么类型,那么接口中的get方法就会生产什么类型的数据
 */

public class Demo05Supperlier {

    public static void main(String[] args) {

        String msgA = "Hello";
        String msgB = "World";

        System.out.println(getString(()-> msgA + msgB));
    }


    public static String getString(Supplier<String> function){

        return function.get();
    }
}
