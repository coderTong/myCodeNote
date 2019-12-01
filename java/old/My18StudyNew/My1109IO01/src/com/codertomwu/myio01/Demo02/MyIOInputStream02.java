package com.codertomwu.myio01.Demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by codew on 11/10/18.
 */

/*
    字节输入流一次读取多个字节的方法:
        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
    明确两件事情:
        1.方法的参数byte[]的作用?
            起到缓冲作用,存储每次读取到的多个字节
            数组的长度一把定义为1024(1kb)或者1024的整数倍
        2.方法的返回值int是什么?
            每次读取的有效字节个数

    String类的构造方法
        String(byte[] bytes) :把字节数组转换为字符串
        String(byte[] bytes, int offset, int length) 把字节数组的一部分转换为字符串 offset:数组的开始索引 length:转换的字节个数
 */


public class MyIOInputStream02  {

    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = new FileInputStream("IOTestInput/input.txt");

        byte[] bytes = new byte[1024];

        int len = 0;
        while ((len = fileInputStream.read(bytes))  != -1){


            System.out.println(new String(bytes,0,len));
        }


        fileInputStream.close();
    }
}
