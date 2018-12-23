package com.codertomwu.lambdafunction1223.LambdaArg;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by codew on 12/23/18.
 */
public class LambdaArgSortClass {


    public static void main(String[] args) {

        String[] array = {"abbc", "ccc", "lkklklks"};

        System.out.println(Arrays.toString(array));
        Arrays.sort(array, newCompartor());

        System.out.println(Arrays.toString(array));
    }

    private static Comparator<String> newCompartor(){

        return (a,b) ->b.length() - a.length();

    }
}
