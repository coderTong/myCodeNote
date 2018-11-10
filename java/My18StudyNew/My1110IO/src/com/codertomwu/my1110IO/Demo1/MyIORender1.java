package com.codertomwu.my1110IO.Demo1;

import java.io.*;

/**
 * Created by codew on 11/10/18.
 */

/*
    java.io.Reader:字符输入流,是字符输入流的最顶层的父类,定义了一些共性的成员方法,是一个抽象类

    共性的成员方法:
        int read() 读取单个字符并返回。
        int read(char[] cbuf)一次读取多个字符,将字符读入数组。
        void close() 关闭该流并释放与之关联的所有资源。

    java.io.FileReader extends InputStreamReader extends Reader
    FileReader:文件字符输入流
    作用:把硬盘文件中的数据以字符的方式读取到内存中

    构造方法:
        FileReader(String fileName)
        FileReader(File file)
        参数:读取文件的数据源
            String fileName:文件的路径
            File file:一个文件
        FileReader构造方法的作用:
            1.创建一个FileReader对象
            2.会把FileReader对象指向要读取的文件
    字符输入流的使用步骤:
        1.创建FileReader对象,构造方法中绑定要读取的数据源
        2.使用FileReader对象中的方法read读取文件
        3.释放资源
 */
public class MyIORender1 {

    public static void main(String[] args) throws IOException {

        test2();
    }


    public static void test2() throws IOException {

        FileReader fileReader = new FileReader("IOTestInput/input.txt");


        // 一个一个的读
//        int len = 0;
//        while ((len = fileReader.read()) != -1){
//
//            System.out.println((char)len);
//        }

        // 一次读1024
        char[]  cs = new char[1024];
        int len = 0;

        while ((len = fileReader.read(cs)) != -1){

            System.out.println(new String(cs,0,len));
        }

        fileReader.close();

    }


    // 字节测试
    public static void test1() throws IOException {

        /*
    使用字节流读取中文文件
    1个中文
        GBK:占用两个字节
        UTF-8:占用3个字节
 */
        FileInputStream  fileInputStream = new FileInputStream("IOTestInput/mvc01.png");
        int len = 0;

        while ((len = fileInputStream.read()) != -1){

            System.out.println((char)len);
        }

        fileInputStream.close();
    }
}
