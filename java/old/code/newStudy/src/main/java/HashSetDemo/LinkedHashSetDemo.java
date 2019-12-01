package HashSetDemo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by codew on 2018/2/1.
 */
public class LinkedHashSetDemo {


    public static void main(String[] args){


        Set<String> set = new LinkedHashSet<>();

        set.add("X");
        set.add("B");
        set.add("S");
        set.add("DA");
        set.add("sdf");

        System.out.println(set);
    }
}
