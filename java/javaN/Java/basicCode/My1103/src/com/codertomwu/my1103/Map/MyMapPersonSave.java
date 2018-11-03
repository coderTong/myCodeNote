package com.codertomwu.my1103.Map;

import java.util.HashMap;
import java.util.HashSet;

public class MyMapPersonSave {

    public static void main(String[] args) {

        HashMap<String, MyMapPerson> map = new HashMap<>();

        map.put("bj", new MyMapPerson("tom", 26));
        map.put("sz", new MyMapPerson("json", 12));
        map.put("wh", new MyMapPerson("java", 22));
        map.put("cs", new MyMapPerson("caer", 20));
        map.put("bj", new MyMapPerson("wutom", 26));

        System.out.println(map);


    }
}
