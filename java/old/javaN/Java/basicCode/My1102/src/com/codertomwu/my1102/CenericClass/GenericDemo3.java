package com.codertomwu.my1102.CenericClass;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo3 {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("sda");
        list2.add("2018年11月2日13:26:32");

        printArray(list1);
        printArray(list2);


    }

    public static void printArray(ArrayList<?> list){

        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }
    }
}
