package MapDemoTest;

import java.util.*;

/**
 * Created by codew on 2018/2/10.
 */




public class HashMapDemo {

    public static void main(String[] args){


        test();
    }

    // 计算一个字符串中, 每个字符串出现的次数

    private static void test(){

        String str = "ddfasfdsgdhdsfhsdfhesyewdf";

        char[] arr = str.toCharArray();

        Map<Character, Integer> map = new TreeMap<>();

        for (char ch: arr) {

            if (map.containsKey(ch)){

                Integer old = map.get(ch);
                map.put(ch, old+1);
            }else {

                map.put(ch, 1);
            }
        }

        System.out.println(map);
    }


    private void test1(){
        Map<String, Object> map = new HashMap<>();

        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
        map.put("Key4", "Value4");
        map.put("Key5", "Value5");
        map.put("Key6", "Value6");

        map.put("Key7", "Value6");

        System.out.println(map);
//        Collection collection = map.values();
//        System.out.println(collection.toArray().length);


        Set<String> keys = map.keySet();
        for (String key: keys) {

            System.out.println(key);
        }


        String value1 = (String) map.get("Key1");
        System.out.println(value1);
        String value = (String) map.remove("Key1");
        System.out.println(value);
    }
}
