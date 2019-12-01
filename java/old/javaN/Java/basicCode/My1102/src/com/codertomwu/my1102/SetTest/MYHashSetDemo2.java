package com.codertomwu.my1102.SetTest;

import java.util.HashSet;

public class MYHashSetDemo2 {

    public static void main(String[] args) {

        HashSet<MyHashPerson> set = new HashSet<>();

        MyHashPerson person1 = new MyHashPerson("s", 13);
        MyHashPerson person2 = new MyHashPerson("s", 13);
        MyHashPerson person3 = new MyHashPerson();

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());

        System.out.println("============================");

        set.add(person1);
        set.add(person2);
        set.add(person3);


    }
}
