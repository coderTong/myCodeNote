package ArraysDemoTest;

import java.util.*;

/**
 * Created by codew on 2018/2/10.
 */
public class ArraysDemoTest {

    public static void main(String[] args){


    }


    // 解决硬伤问题
    private static void test2(){

        List list = Collections.synchronizedList(new ArrayList<>());

        synchronized (list){

            Iterator i = list.iterator();
            while (i.hasNext()){

            }
        }


    }


    private static void test1(){


        // 把数组转换为list对象
        String[] arr = {"d", "c", "sd"};
        List<String> list = Arrays.asList(arr);

//        list.remove(0);// 这个list是Arrays的内部类, 是一个固定大小的list, 所以不能增减
        System.out.println(list);


        // 自动装箱问题
        List<Integer> list1 = Arrays.asList(1,2,3,5,6);
        System.out.println(list1);

        int[] arr2 = {1,3,4,5,6};
        // 直接把int[] 把当对象
        List<int[]> list2 = Arrays.asList(arr2);
        System.out.println(list2);
    }
}
