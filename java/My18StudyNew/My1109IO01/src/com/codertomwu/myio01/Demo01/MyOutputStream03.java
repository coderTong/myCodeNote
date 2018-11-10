package com.codertomwu.myio01.Demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */

/*
    追加写/续写:使用两个参数的构造方法
        FileOutputStream(String name, boolean append)创建一个向具有指定 name 的文件中写入数据的输出文件流。
        FileOutputStream(File file, boolean append) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
        参数:
           String name,File file:写入数据的目的地
           boolean append:追加写开关
            true:创建对象不会覆盖源文件,继续在文件的末尾追加写数据
            false:创建一个新文件,覆盖源文件
    写换行:写换行符号
        windows:\r\n
        linux:/n
        mac:/r
 */
public class MyOutputStream03 {


    public static void main(String[] args) throws IOException {


        System.out.println("这个是追加的....");

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


        FileOutputStream fileOutputStream = new FileOutputStream(file, true);// 是的我要追加

        for (int i = 0; i < 10; i++) {

            fileOutputStream.write("2018年11月10日00:14:38".getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }

        // 别忘记关
        fileOutputStream.close();


    }
}
