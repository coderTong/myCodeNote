package com.codertomwu.my1110IOBuffered.ReverseStream;

import java.io.*;

/**
 * Created by codew on 11/10/18.
 */


/*
    练习：转换文件编码
        将GBK编码的文本文件，转换为UTF-8编码的文本文件。

    分析:
        1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称GBK
        2.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称UTF-8
        3.使用InputStreamReader对象中的方法read读取文件
        4.使用OutputStreamWriter对象中的方法write,把读取的数据写入到文件中
        5.释放资源
 */
// 将 GBK 转换成UTF
public class Demo04GBK2UTF {


    public static void main(String[] args) throws IOException {


        InputStreamReader  inputStreamReader = new InputStreamReader(new FileInputStream("BufferedIO/gbk.txt"), "GBK");

        OutputStreamWriter ot =  new OutputStreamWriter(new FileOutputStream("BufferedIO/ccUtf.txt"), "UTF-8");

        int len = 0;

        while ((len = inputStreamReader.read()) != -1){

            ot.write(len);
        }

        inputStreamReader.close();
        ot.close();

    }
}
