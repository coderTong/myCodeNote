package com.codertomwu.my1102.IteratorT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyIterator {

    public static void main(String[] args) {


        Collection<String> collection = new ArrayList<>();

        collection.add("java");
        collection.add("OC");
        collection.add("swift");
        collection.add("c");

        Iterator iterator = collection.iterator();
//        for (int i = 0; i < collection.size(); i++) {
//
//            if (iterator.hasNext()) {
//
//                System.out.println(iterator.next());
//            }
//
//        }

//        while (iterator.hasNext()){
//
//            System.out.println(iterator.next());
//        }


        // 增强for循环, 是java5以后的
        for (String str:
             collection) {

            System.out.println(str);
        }

    }

}
