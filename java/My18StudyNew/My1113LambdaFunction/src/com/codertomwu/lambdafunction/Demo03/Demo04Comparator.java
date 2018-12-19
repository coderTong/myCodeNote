package com.codertomwu.lambdafunction.Demo03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by codew on 11/13/18.
 */
public class Demo04Comparator {

    public static Comparator<String> myComparatorTest(){

        return (a,b) -> b.length() - a.length();
    }

    public static void main(String[] args) {

        String[] array = {"abc", "ab", "abcd"};

        System.out.println(Arrays.toString(array));
        Arrays.sort(array, myComparatorTest());
        System.out.println(Arrays.toString(array));

    }
}
