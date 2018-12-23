package com.codertomwu.lambdafunction1223.Consumer;

import java.util.function.Consumer;

/**
 * Created by codew on 12/23/18.
 */
public class MyConsumer {


    private static void consumerString(Consumer<String> function){

        function.accept("hello");
    }

    public static void main(String[] args) {

        consumerString(s-> System.out.println(s));
    }
}

