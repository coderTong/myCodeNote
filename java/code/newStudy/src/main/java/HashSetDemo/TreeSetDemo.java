package HashSetDemo;

import java.util.TreeSet;

/**
 * Created by codew on 2018/2/1.
 */
public class TreeSetDemo {

    public static void main(String[] args){

        TreeSet<String> set = new TreeSet<>();

        set.add("Y");
        set.add("a");
        set.add("1");
        set.add("S");
        set.add("4");
        set.add("H");
        set.add("C");

        System.out.println(set);

        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.headSet("4"));
    }
}
