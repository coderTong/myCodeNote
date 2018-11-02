package com.codertomwu.my1102.MyCollection;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollectionT {

    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();

        collection.add("嘿嘿");
        collection.add("啪啪");
        collection.add("蹦蹦");
        collection.add("xixi");

        System.out.println(collection);


        System.out.println(collection);
        // 有没？
        boolean b = collection.contains("xixi");
        System.out.println(b);

    }
}
