package com.codertomwu.my1103.Map;

public class MyMapPerson {

    private String name;
    private int age;


    @Override
    public String toString() {
        return "MyMapPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public MyMapPerson() {
    }

    public MyMapPerson(String name, int age) {
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
