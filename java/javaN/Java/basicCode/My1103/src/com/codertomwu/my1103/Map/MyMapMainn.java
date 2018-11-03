package com.codertomwu.my1103.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMapMainn {


    public static void main(String[] args) {

        Map<String, Object> map = new HashMap();
        map.put("Id", "341jkfadasd");
        map.put("name", "张无忌");
        map.put("age", "22");
        map.put("class", "8");

        System.out.println(map);
        map.remove("class");
        System.out.println(map);
        String name = (String) map.get("name");
        System.out.println(map);
        boolean has = map.containsKey("age");
        System.out.println(has);

        System.out.println(map.keySet());
        System.out.println(map);

        System.out.println(map.entrySet());

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){

            System.out.println(map.get(iterator.next()));
        }

        for (String key :
                map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
