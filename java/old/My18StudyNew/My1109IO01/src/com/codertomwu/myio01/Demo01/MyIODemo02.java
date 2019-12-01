package com.codertomwu.myio01.Demo01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by codew on 11/9/18.
 */

/*
    一次写多个字节的方法:
        - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
 */
public class MyIODemo02 {

    public static void main(String[] args) throws IOException {

        File dir = new File("IOTest");
        if (dir.isDirectory() == false){

            System.out.println("文件夹还没有");
            dir.mkdir();
        }else {

            System.out.println("文件夹已经存在");
        }

        File file = new File(dir,"1.txt");
        System.out.println(file.getAbsolutePath());
        file.createNewFile();


        FileOutputStream fileOutputStream = new FileOutputStream(file);


        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);


        // 一次性写多点呢

        byte[] bytes = {65,66,67,68,69,70,71,72};

        fileOutputStream.write(bytes);


        /*
            public void write(byte[] b, int off, int len) ：把字节数组的一部分写入到文件中
                int off:数组的开始索引
                int len:写几个字节
         */
        // 从数组索引开始, 后面是写几个字节
        fileOutputStream.write(bytes,2, bytes.length-2);

        byte[] charByte = "一串字符串".getBytes();
        System.out.println(Arrays.toString(charByte));
        fileOutputStream.write(charByte);

    }
}
