package com.codertomwu.my1110IOBuffered.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by codew on 11/10/18.
 */


/*
    java.io.ObjectInputStream extends InputStream
    ObjectInputStream:对象的反序列化流
    作用:把文件中保存的对象,以流的方式读取出来使用

    构造方法:
        ObjectInputStream(InputStream in) 创建从指定 InputStream 读取的 ObjectInputStream。
        参数:
            InputStream in:字节输入流
    特有的成员方法:
        Object readObject() 从 ObjectInputStream 读取对象。

    使用步骤:
        1.创建ObjectInputStream对象,构造方法中传递字节输入流
        2.使用ObjectInputStream对象中的方法readObject读取保存对象的文件
        3.释放资源
        4.使用读取出来的对象(打印)

     readObject方法声明抛出了ClassNotFoundException(class文件找不到异常)
     当不存在对象的class文件时抛出此异常
     反序列化的前提:
        1.类必须实现Serializable
        2.必须存在类对应的class文件
 */
public class MyObjectInputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("BufferedIO/person.txt"));

        Object object = inputStream.readObject();
        inputStream.close();

        System.out.println(object);

        MyPerson person = (MyPerson)object;

        System.out.println(person.getName());

    }
}
