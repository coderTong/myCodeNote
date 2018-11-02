package com.codertomwu.my1102.SetTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet {

    public static void main(String[] args) {


        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(4);
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Integer i: set) {
            System.out.println(i);
        }


        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }
}
