package com.codertomwu.lambdafunction.Demo05Consumer;

import java.util.function.Consumer;

/**
 * Created by codew on 11/13/18.
 */
public class DemoConsumerAndThen {

    public static void main(String[] args) {

        method("Hello",
                // con1
                (gg)->{
                    System.out.println("嘿嘿01:" + gg);
                    System.out.println(gg.toUpperCase());
                },
                // con2
                (gg)->{


                    System.out.println("嘿嘿02:" + gg);
                });
    }

    public static void method(String s, Consumer<String> con1, Consumer<String> con2){

//        con1.andThen(con2).accept(s);;
        con2.andThen(con1).accept(s);;
    }
}
