package com.codertomwu.my1103.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyEntryTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap();
        map.put("Id", "341jkfadasd");
        map.put("name", "张无忌");
        map.put("age", "22");
        map.put("class", "8");

        Set<Map.Entry<String,String>> set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){

            Map.Entry entry = (Map.Entry) iterator.next();

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for (Map.Entry entry:map.entrySet()) {

            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
