package com.codertomwu.lambd2.Demo1;

import java.util.Arrays;
import java.util.Comparator;

public class DemoMain {

    public static void main(String[] args) {

       //

        Person[] pArr = {

                new Person("yaojun", 26),
                new Person("lilingfeng", 30),
                new Person("huangpanqing", 27),
                new Person("xixi", 20)
        };

        Arrays.sort(pArr, (Person o1, Person o2)->{

            return o1.getAge()-o2.getAge();
        });

        // 省略写法， 类型省略， 大括号， ；
        Arrays.sort(pArr, (o1,o2)-> o1.getAge()-o2.getAge());


//        Arrays.sort(pArr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });

        // 遍历

        for (Person p: pArr) {

            System.out.println(p);
        }
    }
}
