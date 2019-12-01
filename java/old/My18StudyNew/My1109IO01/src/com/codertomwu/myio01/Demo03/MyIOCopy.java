package com.codertomwu.myio01.Demo03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */


/*
    文件复制练习:一读一写

    明确:
        数据源: c:\\1.jpg
        数据的目的地: d:\\1.jpg

    文件复制的步骤:
        1.创建一个字节输入流对象,构造方法中绑定要读取的数据源
        2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
        3.使用字节输入流对象中的方法read读取文件
        4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
        5.释放资源
 */

public class MyIOCopy {

    public static void main(String[] args) throws IOException {


        long s = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("IOTestInput/mvc01.png");

        FileOutputStream fileOutputStream = new FileOutputStream("IOTestInput/02.png");

        byte[]  bytes = new byte[1024];

        int len = 0;

        while ((len = fileInputStream.read(bytes)) != -1){

            fileOutputStream.write(bytes,0,len);
        }

        fileOutputStream.close();
        fileInputStream.close();

        long e = System.currentTimeMillis();

        System.out.println("耗时:" + (e-s) + "毫秒");
    }
}
