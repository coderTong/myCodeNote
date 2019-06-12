package SetMyTestDemo;

import java.util.*;

/**
 * Created by codew on 6/11/19.
 */
public class SetMainDemo {

    public static void main(String[] args) {

        System.out.println("long time long see");


        myQueue();

    }


    public static void myQueue()
    {
        ArrayDeque deque = new ArrayDeque();

        deque.add("ss1");
        deque.add("ss2");
        deque.add("ss3");
        deque.add("ss4");



        System.out.println(deque);

    }


    public static void mySetTest(){


        HashSet set = new HashSet();
        set.add("ha");
        set.add("嘻嘻");
        set.add("sad");
        set.add("asfq");
        set.add("阿斯达");
        set.add("安全");
        set.add("嘻嘻");

//        for (int i = 0; i < 5; i++) {
//
//            System.out.println(set);
//        }



        LinkedHashSet hashSet = new LinkedHashSet();

        hashSet.add("ha");
        hashSet.add("嘻嘻");
        hashSet.add("sad");
        hashSet.add("asfq");
        hashSet.add("阿斯达");
        hashSet.add("安全");
        hashSet.add("嘻嘻");

        System.out.println(hashSet);
    }


    public static void myListTest(){

/**
 * 2019年06月11日18:27:53
 * 链表加数组的特性结合
 * */
        LinkedList <String> linkedList = new LinkedList();

        linkedList.add("haha1");
        linkedList.add("haha2");
        linkedList.add("haha3");
        linkedList.add("haha4");
        linkedList.add("haha5");
        linkedList.add("haha6");

        System.out.println(linkedList);

        System.out.println(linkedList.indexOf("haha5"));
        System.out.println(linkedList);

        linkedList.addFirst(":");
        System.out.println(linkedList);


        linkedList.add(4, "asdd");
        System.out.println(linkedList);

        for (String str:linkedList) {

            System.out.println(str);

        }

        System.out.println(linkedList.get(1));

//        ArrayList
//        ArrayList arrayList = new ArrayList();




        Vector vector = new Vector();

        Student student = new Student();


        vector.add("李四");
        vector.add("z");
        vector.add(0);
        vector.add(student);


        for (Object obj: vector) {

            System.out.println(obj.getClass());
        }

        System.out.println(vector.get(1));
        System.out.println(vector.get(0));


        Stack stack = new Stack();

        stack.push("ss1");
        stack.push("ss2");
        stack.push("ss3");
        stack.push("ss4");
        stack.push("ss5");


        System.out.println(stack.search("ss5"));

//        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.get(0));
        stack.remove(2);
        System.out.println(stack);



    }

}
