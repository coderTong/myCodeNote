package com.codertomwu.lambdafunction.Demo04;

import java.util.function.Supplier;

/**
 * Created by codew on 11/13/18.
 */
public class Demo02Supplier {


    public static void main(String[] args) {


        int[] arr = {12,23,9,99,0,3};

        int maxValue = getMax(()->{

            int max = 0;

            for (int r: arr) {

                if (r > max){

                    max = r;
                }
            }

            return max;

        });

        System.out.println(maxValue);
    }

    public static int getMax(Supplier<Integer> supplier){

        return supplier.get();
    }
}
