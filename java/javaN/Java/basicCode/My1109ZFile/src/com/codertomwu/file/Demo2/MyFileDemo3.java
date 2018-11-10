package com.codertomwu.file.Demo2;

import java.io.File;
import java.io.IOException;

/*
   File类创建删除功能的方法
       - public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
       - public boolean delete() ：删除由此File表示的文件或目录。
       - public boolean mkdir() ：创建由此File表示的目录。
       - public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
*/
public class MyFileDemo3 {


    public static void main(String[] args) throws IOException {

        show3();
    }




    /*
        public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        创建文件的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
            true:文件不存在,创建文件,返回true
            false:文件存在,不会创建,返回false
        注意:
            1.此方法只能创建文件,不能创建文件夹
            2.创建文件的路径必须存在,否则会抛出异常

        public boolean createNewFile() throws IOException
        createNewFile声明抛出了IOException,我们调用这个方法,就必须的处理这个异常,要么throws,要么trycatch
     */
    public static void show1() throws IOException {


        File file = new File("C:\\Users\\codertom\\Desktop\\test\\1.txt");

        System.out.println(file.createNewFile());
        File file2 = new File("C:\\Users\\codertom\\Desktop\\test\\xxxtxt");
        System.out.println(file2.createNewFile());
    }


    /*
       public boolean mkdir() ：创建单级空文件夹
       public boolean mkdirs() ：既可以创建单级空文件夹,也可以创建多级文件夹
       创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
            true:文件夹不存在,创建文件夹,返回true
            false:文件夹存在,不会创建,返回false;构造方法中给出的路径不存在返回false
        注意:
            1.此方法只能创建文件夹,不能创建文件
     */
    public static void show2(){

        File file = new File("C:\\Users\\codertom\\Desktop\\test\\2.txt");

        System.out.println(file.mkdir());
        File file2 = new File("C:\\Users\\codertom\\Desktop\\test\\txt");
        System.out.println(file2.mkdir());

        File file3 = new File("hei");
        System.out.println(file3.getAbsoluteFile());
        System.out.println(file3.mkdir());
        File file4 = new File("hei/sds/dsd");

        System.out.println(file4.mkdirs());

        File f4 = new File("08_F\\ccc");
        boolean b4 = f4.mkdirs();
        System.out.println("b4:"+b4);
    }
    public static void show3(){

        /*
        public boolean delete() ：删除由此File表示的文件或目录。
        此方法,可以删除构造方法路径中给出的文件/文件夹
        返回值:布尔值
            true:文件/文件夹删除成功,返回true
            false:文件夹中有内容,不会删除返回false;构造方法中路径不存在false
        注意:
            delete方法是直接在硬盘删除文件/文件夹,不走回收站,删除要谨慎
     */

        File file4 = new File("hei/sds/dsd");
        System.out.println(file4.delete());
    }
}

