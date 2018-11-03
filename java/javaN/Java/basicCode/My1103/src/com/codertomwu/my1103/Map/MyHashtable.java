package com.codertomwu.my1103.Map;

import java.util.HashMap;
import java.util.Hashtable;

public class MyHashtable {

    public static void main(String[] args) {


        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put(null, "sds");
        hashMap.put("bb", null);
        hashMap.put(null, "sdaasdfa");
        System.out.println(hashMap);

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, "sss");
        hashtable.put("sads", null);
        hashtable.put(null, "sdasd");

        System.out.println(hashtable);



    }
}
