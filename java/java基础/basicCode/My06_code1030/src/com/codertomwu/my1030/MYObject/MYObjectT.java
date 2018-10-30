package com.codertomwu.my1030.MYObject;

import java.util.Objects;

public class MYObjectT {

    public static void main(String[] args) {

        String s1 = null;
        String s2 = "abc";
//        boolean b = s1.equals(s2);
//        System.out.println(b);

        /**
         * public static boolean equals(Object a, Object b) {
         *         return (a == b) || (a != null && a.equals(b));
         *     }
         * */
        boolean b2 = Objects.equals(s1,s2);
        System.out.println(b2);


    }
}
