package MapMyTestDemo;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * Created by codew on 6/12/19.
 */
public class MapMyDemoMain {

    public static void main(String[] args) {


        System.out.println("嘿 Map");

        Hashtable hashtable = new Hashtable();


        /**
         *
         * Map
         *
         * Hashtable   HashMap          SortedMap
         *
         * Properties  LinkedHashMap    NavigableMap
         *
         *                              TreeMap
         *
         * */


//        HashMap;
//        LinkedHashMap;
//        Hashtable;

//        SortedMap;
//        NavigableMap;
//        Properties
//        TreeMap;


        testDemo();
    }


    public static void testDemo(){

        System.out.println("请录入一个字符串:");

        String line = new Scanner(System.in).nextLine();

        findChar(line);
    }


    private static void findChar(String line){

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (!map.containsKey(c)){

                map.put(c, 1);

            }else {

                Integer count = map.get(c);
                map.put(c, ++count);
            }
        }

        System.out.println(map);
    }


    public static void testLinkedHashMap(){

        Map <MapStudentTest, String> map = new LinkedHashMap<MapStudentTest, String>();

        map.put(new MapStudentTest("lisi", 20), "上海");
        map.put(new MapStudentTest("zs", 21), "北京");
        map.put(new MapStudentTest("xb", 38), "成都");
        map.put(new MapStudentTest("hh", 8), "新晃");
        map.put(new MapStudentTest("wode", 98), "大龙");
        map.put(new MapStudentTest("lala", 48), "玉屏");
        map.put(new MapStudentTest("lala", 48), "玉屏");
//        System.out.println(map);



        Set<Map.Entry<MapStudentTest, String>> entrySet = map.entrySet();

        for (Map.Entry<MapStudentTest, String> entry: entrySet) {

            System.out.println(entry.getKey() + "----" + entry.getValue());

        }

    }

    public static void test2(){

        Map <MapStudentTest, String> map = new HashMap<MapStudentTest, String>();

        map.put(new MapStudentTest("lisi", 20), "上海");
        map.put(new MapStudentTest("zs", 21), "北京");
        map.put(new MapStudentTest("xb", 38), "成都");
        map.put(new MapStudentTest("hh", 8), "新晃");
        map.put(new MapStudentTest("wode", 98), "大龙");
        map.put(new MapStudentTest("lala", 48), "玉屏");
        map.put(new MapStudentTest("lala", 48), "玉屏");

//        System.out.println(map);


        Set<MapStudentTest> keySet = map.keySet();

        for (MapStudentTest key:keySet) {

            String value = map.get(key);

            System.out.println(key.getName());
            System.out.println(key.getAge());
            System.out.println(key.toString() + "...." + value);

        }



    }



    public static void testHLMap()
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("name", "周星驰");
        hashMap.put("age", "50");
        hashMap.put("key", "哈哈");

        System.out.println(hashMap);


        System.out.println(hashMap.get("name"));
        
        
        Set <Map.Entry<String, String>> entrySet = hashMap.entrySet();

        for (Map.Entry<String,String> entry:entrySet
             ) {

            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("key" + key + " " + "value" + value);

        }
    }
}
