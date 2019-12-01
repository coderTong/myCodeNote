package com.codertomwu.my1110IOBuffered.ObjectStream;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by codew on 11/10/18.
 */


/*
    练习：序列化集合
        当我们想在文件中保存多个对象的时候
        可以把多个对象存储到一个集合中
        对集合进序列化和反序列化
    分析:
        1.定义一个存储Person对象的ArrayList集合
        2.往ArrayList集合中存储Person对象
        3.创建一个序列化流ObjectOutputStream对象
        4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
        5.创建一个反序列化ObjectInputStream对象
        6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
        7.把Object类型的集合转换为ArrayList类型
        8.遍历ArrayList集合
        9.释放资源
 */
public class MyObjectStreamTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        System.out.println("存一堆对象");


//        ArrayList<Object> list = new ArrayList<>();
//
//        list.add(new MyPerson("杨过", 20));
//        list.add(new MyStudentClass("三班", 1223));
//
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("BufferedIO/objs.txt"));
//
//        outputStream.writeObject(list);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("BufferedIO/objs.txt"));
        Object o = inputStream.readObject();

        ArrayList<Object> lista = (ArrayList<Object>)o;

        for (Object o1:lista) {

            if (o1.getClass() == MyPerson.class){

                MyPerson p = (MyPerson)o1;
                System.out.println(p);
                System.out.println(p.getName());
            }else {

                MyStudentClass  myStudentClass = (MyStudentClass)o1;
                System.out.println(o1);
                System.out.println(((MyStudentClass) o1).getClassName());
            }
        }



    }
}
