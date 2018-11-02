package com.codertomwu.my1102.ListTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1List {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // add
        list.add("aaa");
        list.add("aaa");
        list.add("BBB");
        list.add("ccc");

        //
        list.add(3,"ggg");

        System.out.println(list.get(3));
        list.remove(2);
        list.set(3, "heihei");
        System.out.println(list);


        Iterator iterator = list.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }

        for (String str:list) {
            System.out.println(str);
        }


    }

}
