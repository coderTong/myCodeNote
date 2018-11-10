package com.codertomwu.my1110IO.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */

/*
    java.io.Writer:字符输出流,是所有字符输出流的最顶层的父类,是一个抽象类

    共性的成员方法:
        - void write(int c) 写入单个字符。
        - void write(char[] cbuf)写入字符数组。
        - abstract  void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        - void write(String str)写入字符串。
        - void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        - void flush()刷新该流的缓冲。
        - void close() 关闭此流，但要先刷新它。

    java.io.FileWriter extends OutputStreamWriter extends Writer
    FileWriter:文件字符输出流
    作用:把内存中字符数据写入到文件中

    构造方法:
        FileWriter(File file)根据给定的 File 对象构造一个 FileWriter 对象。
        FileWriter(String fileName) 根据给定的文件名构造一个 FileWriter 对象。
        参数:写入数据的目的地
            String fileName:文件的路径
            File file:是一个文件
        构造方法的作用:
            1.会创建一个FileWriter对象
            2.会根据构造方法中传递的文件/文件的路径,创建文件
            3.会把FileWriter对象指向创建好的文件

    字符输出流的使用步骤(重点):
        1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
        2.使用FileWriter中的方法write,把数据写入到内存缓冲区中(字符转换为字节的过程)
        3.使用FileWriter中的方法flush,把内存缓冲区中的数据,刷新到文件中
        4.释放资源(会先把内存缓冲区中的数据刷新到文件中)
 */
public class Demo01Writer {


    public static void main(String[] args) throws IOException {


        File dir = new File("FileWriter");

        if (dir.isDirectory() == false){

            dir.mkdir();
        }

        File path = new File(dir, "text.txt");
        if (path.isFile() == false){
            path.createNewFile();
        }


        // FileWriter 只有操作文件的能力, 如果没有文件夹会报错,
//        FileWriter fileWriter = new FileWriter(path);
        FileWriter fileWriter = new FileWriter("FileWriter/text2.txt",true);



        // 写一个
        fileWriter.write(97);

        // 写一组
        char[] bytes = {12,90,99,98,'H','4'};
        fileWriter.write(bytes);

        //
        char[] bytes2 = {'L','O','V','E'};
        fileWriter.write(bytes2,0,bytes2.length);

        // 字符串
        fileWriter.write("\nLOVE AN");

        fileWriter.flush();
        fileWriter.close();
    }

}
