package com.codertomwu.lambdafunction1223.Supplier;

import java.util.function.Supplier;

/**
 * Created by codew on 12/23/18.
 */
public class MySupplier {

    public static int getMax(Supplier<Integer> sup){

        return sup.get();
    }

    private static String getString(Supplier<String> function)
    {
        return function.get();
    }

    public static void main(String[] args) {
        String msgA = "hello ";
        String msgB = " world";

        System.out.println(getString(()->msgA+msgB));


        int arr[] = {2,3,4,52,333,23};

        int maxNum = getMax(()->{

            int max = arr[0];
            for (int i: arr) {
                if (i > max){
                    max = i;
                }
            }

            return max;
        });

        System.out.println(maxNum);

    }
}
