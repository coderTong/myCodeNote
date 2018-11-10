package com.codertomwu.my1110IOBuffered.ObjectStream;

import java.io.Serializable;

/**
 * Created by codew on 11/10/18.
 */
public class MyPerson implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public MyPerson() {
    }

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
