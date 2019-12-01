package HashSetDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by codew on 2018/1/31.
 */
public class HashSetDemo {

    public static void main(String[] args){

        Set<String> set = new HashSet<>();

        set.add("A");
        set.add("Z");
        set.add("OM");
        set.add("hi");
        set.add("12");

        System.out.println(set);
    }

}
