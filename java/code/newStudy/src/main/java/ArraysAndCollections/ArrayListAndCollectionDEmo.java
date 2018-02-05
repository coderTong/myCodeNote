package ArraysAndCollections;

import java.util.*;

/**
 * Created by codew on 2018/1/31.
 */
public class ArrayListAndCollectionDEmo {

    public static void main(String[] args){


       List<Object> list1 = Collections.EMPTY_LIST;
       List<Object> list2 = Collections.emptyList();
       List<Object> list3 = new ArrayList<>();

    }


    private static void test1(){
        List<String> list = Arrays.asList("A", "B", "C");

        list = new ArrayList<>(list);

        list.remove(0);
        System.out.println(list);

        List<Date> dates = Arrays.asList(new Date(), new Date(),new Date());
        System.out.println(dates);
    }
}
