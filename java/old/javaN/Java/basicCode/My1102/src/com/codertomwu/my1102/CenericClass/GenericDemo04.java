package com.codertomwu.my1102.CenericClass;

// 泛型的上下限定

import java.util.ArrayList;
import java.util.Collection;

/***
 * 上： ？ extends E 本 子类
 * 下： ？ super E 本身 父类
 * */
public class GenericDemo04 {


    public static void main(String[] args) {


        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();


//        getElement1(list1);
//        getElement1(list2);
//        getElement1(list3);
//        getElement1(list4);
//
//
//        getElement2(list1);
//        getElement2(list2);
//        getElement2(list3);
//        getElement2(list4);
    }


    public static void getElement1(Collection<? extends Number> coll){}
    public static void getElement2(Collection<? super Number> coll){}
}
