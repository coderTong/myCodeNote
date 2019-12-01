package com.codertomwu.my1027.MyString;

import java.util.Arrays;

public class MYArraysTest {

    public static void main(String[] args) {

        System.out.println("Arrays 学习");

        int[] iArr = {10, 20, 3, 7, 2};;
        System.out.println(iArr);
        Arrays.sort(iArr);
        System.out.println(iArr);
        System.out.println(Arrays.toString(iArr));


        String str  = "dasafgergqwrghrhfhergrgfv";
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        System.out.println(strArr);
        for (int i = strArr.length - 1; i >= 0; i--) {

            System.out.println(strArr[i]);
        }



    }

}
