package ClassDemo;

import java.lang.reflect.Constructor;

/**
 * Created by codew on 2018/1/29.
 */

class Person
{
    public Person(){

        System.out.println("无参数");
    }

    public Person(String name){

        System.out.println("名字:" + name);
    }

    private Person(String name, int age){

        System.out.println("name:" + name + " " + "age:" + age);
    }
}

public class ConstructorCreateObjDemo {

    public static void main(String[] args) throws Exception{

        // 传统方式
        new Person("xx");


        // =====================
//        Class<Person> clz = Person.class;
//        Constructor<Person> con = clz.getConstructor();
//        con.newInstance();


        // =====================
//        public Person(String name)

//        Class<Person> clz = Person.class;
//        Constructor<Person> con = clz.getConstructor(String.class);
//        con.newInstance("lucy");

        // =====================
//        private Person(String name, int age)
        // 方法是私有的,,so
//        Class<Person> clz = Person.class;
//        Constructor<Person> con = clz.getDeclaredConstructor(String.class, int.class);
//        System.out.println(con);
//        // 设置当前构造器可以访问
//        con.setAccessible(true);
//        con.newInstance("lucy", 17);

        // =====================
        // `如果:一个类中的构造器` `是外界可以直接访问,同时没有参数`.,那么可以`直接使用Class类中的newInstance方法创建对象.`
        Class<Person> clz = Person.class;
        clz.newInstance();
    }
}
