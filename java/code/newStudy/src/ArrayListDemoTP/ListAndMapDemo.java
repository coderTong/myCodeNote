package ArrayListDemoTP;

import java.util.*;

/**
 * Created by codew on 2018/1/31.
 */
public class ListAndMapDemo {

    public static void main(String[] args){

        Set<String> names1 = new HashSet<>();
        names1.add("老牛");
        names1.add("老何");
        names1.add("老蔡");

        Set<String> names2 = new HashSet<>();
        names2.add("周星驰");
        names2.add("周杰伦");
        names2.add("周大福");


        Map<String, Set<String>> classMap1 = new HashMap<>();
        classMap1.put("普通人", names1);
        classMap1.put("名人", names2);




        Map<String, Set<String>> classMap2 = new HashMap<>();
        classMap2.put("三个姓", names1);
        classMap2.put("都姓周", names2);


        // 使用list来存储所有学员的学生姓名
        List< Map<String, Set<String>> > school = new ArrayList<>();

        school.add(classMap1);
        school.add(classMap2);

        System.out.println(school);
    }
}
