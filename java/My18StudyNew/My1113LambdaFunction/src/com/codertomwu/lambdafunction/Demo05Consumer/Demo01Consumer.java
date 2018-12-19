package com.codertomwu.lambdafunction.Demo05Consumer;

import java.util.function.Consumer;

/**
 * Created by codew on 11/13/18.
 */

/*
    java.util.function.Consumer<T>接口则正好与Supplier接口相反，
        它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定。
    Consumer接口中包含抽象方法void accept(T t)，意为消费一个指定泛型的数据。

   Consumer接口是一个消费型接口,泛型执行什么类型,就可以使用accept方法消费什么类型的数据
   至于具体怎么消费(使用),需要自定义(输出,计算....)
 */
public class Demo01Consumer {


    public static void main(String[] args) {

        method("无糖口香糖", (String name)->{

            System.out.println(name);

            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }

    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }
}
