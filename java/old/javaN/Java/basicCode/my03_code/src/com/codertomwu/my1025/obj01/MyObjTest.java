package com.codertomwu.my1025.obj01;

public class MyObjTest {

    public static void main(String[] args) {

        STStudent stu1 = new STStudent();
        stu1.setAge(20);
        stu1.setName("tom");

        System.out.println("name:" + stu1.getName() + ",age: " + stu1.getAge());


        System.out.println("==========");

        STStudent stu2 = new STStudent(20, "杰克");
        System.out.println("name:" + stu2.getName() + ",age: " + stu2.getAge());

    }
}
