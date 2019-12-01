package com.codertomwu.my1027.MyString;

public class MyStringTest {

    public static void main(String[] args) {

        Person p = new Person();

        System.out.println("Hello String");

        String str1 = "hello";
        String str2 = "World";
        String str3 = str1.concat(str2);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // 1.获取？
        char ch = "hello".charAt(1);
        System.out.println(ch);
        System.out.println("===================");



        System.out.println("hello".indexOf("ll"));
        System.out.println("===================");

        String strT = "HelloJava";
        String strT2 = strT.substring(5);
        System.out.println(strT);
        System.out.println(strT2);



    }




    // 2.截取
}
