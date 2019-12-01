package com.codertomwu.my1102.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class MYCollectionsMain {

    public static void main(String[] args) {
        System.out.println("2018年11月3日01:43:20");
        // 集合工具类


        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(5);
        list.add(9);
        list.add(7);

        System.out.println(list);
        Collections.addAll(list, 1,34,90);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        // 打乱顺序
        Collections.shuffle(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

    }
}
