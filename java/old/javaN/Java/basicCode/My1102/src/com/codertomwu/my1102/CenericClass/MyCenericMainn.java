package com.codertomwu.my1102.CenericClass;

public class MyCenericMainn {


    public static void main(String[] args) {

        MyGenericTest test = new MyGenericTest();
        test.setName("str");
        Object name = test.getName();


        // 创建MyGenericTest对象， 泛型使用
        MyGenericTest<Integer> test1 = new MyGenericTest<>();
        test1.setName(20);
        Integer name1 = test1.getName();

        MyGenericTest<String> test2 = new MyGenericTest<>();
        test2.setName("name");
        String name2 = test2.getName();


    }
}
