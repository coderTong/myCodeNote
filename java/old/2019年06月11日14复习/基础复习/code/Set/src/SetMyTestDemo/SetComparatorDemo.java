package SetMyTestDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SetComparatorDemo {


    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<String>();
        list.add("bdaasa");
        list.add("e");
        list.add("abass");
        list.add("daassssss");


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length() - o2.length();

            }
        });





        System.out.println(list);

    }



}
