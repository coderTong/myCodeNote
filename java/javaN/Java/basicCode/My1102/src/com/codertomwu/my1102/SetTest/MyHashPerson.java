package com.codertomwu.my1102.SetTest;

// 2018年11月3日01:10:05 学习HashSet存储自定义类型的元素
// 必须重写equals和hashCode
public class MyHashPerson {

    private String name;
    private int age;

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

    public MyHashPerson() {

    }

    public MyHashPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
