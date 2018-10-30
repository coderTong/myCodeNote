package com.codertomwu.my1025.MyArrayList;

import java.util.ArrayList;
import java.util.Random;

public class MyArrayListMe {

    public static void main(String[] args) {

        System.out.println("hello ArrayList");

        ArrayList<String> strList = new ArrayList<>();

        strList.add("迪丽热巴");
        strList.add("艾热");
        strList.add("jeck");

        System.out.println(strList);


        strList.remove(1);
        System.out.println(strList);

        System.out.println(strList.size());


        System.out.println("==============");
        ArrayList<Integer> iArr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            iArr.add(new Random().nextInt(20));
        }

        System.out.println(iArr);

        int c = iArr.get(2);

        System.out.println(c);
    }
}
