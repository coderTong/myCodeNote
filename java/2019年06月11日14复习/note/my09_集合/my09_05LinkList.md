# LinkedList



1. 底层是一个链表结构， 查询慢， 增删快

2. 里面包含了大量操作首尾元素的方法

   它里面含有特有方法， 并不能使用多态



```java

package com.codertomwu.my1102.ListTest;

import java.util.LinkedList;

public class ListLinkList {

    public static void main(String[] args) {

//        LinkedList

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("bbb");
        linkedList.add("ccc");
        linkedList.add("ddd");

        System.out.println(linkedList);
        linkedList.addFirst("000");
        System.out.println(linkedList);
        linkedList.addLast("end");
        System.out.println(linkedList);
        linkedList.push("sss");
        linkedList.push("yyy");
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        linkedList.pop();
        System.out.println(linkedList);



    }
}


```

