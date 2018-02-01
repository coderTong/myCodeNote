package ArrayListDemoTP;

import java.util.*;

/**
 * Created by codew on 2018/1/31.
 */


public class ArrayListDemoTest {

    public static void main(String[] args){

        testFor();
    }


    private static void testFor(){

        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

//        for (Object obj: list) {
//
//            System.out.println(obj);
//
//            if (obj.equals("C")){
//                System.out.println("看到C罗~");
//
//                list.remove(obj);
//            }
//        }

        Iterator it = list.iterator();
        while (it.hasNext()){

            Object object = it.next();

            if (object.equals("C")){
                System.out.println("看到C罗~");

                it.remove();
            }
        }
        System.out.println(list);


    }

    private static void testLinkedList(){

        LinkedList linkedList = new LinkedList();
        linkedList.add("hi Android");
        linkedList.add("hi openGL");
        linkedList.add("hi Shader");
        linkedList.add("hi iOS");


       String str = (String)linkedList.get(3);
        System.out.println(str);
//        LinkedList  linkedList2 = Collections.synchronizedList(linkedList);

        // 使用迭代器 接口 Iterable<T>
        Iterator it = linkedList.iterator();

        while (it.hasNext()){

            System.out.println(it.next());
        }


    }
    private static void testArrayList(){

        ArrayList list = new ArrayList();

        list.add("cc");
        list.add("AA");


        list.add(1, "BB");
        list.set(0, "AA");
        list.set(2, "CC");

//        list.removeAll()
        System.out.println(list);
        System.out.println(list.size());

    }

}
