package com.codertomwu.file.Demo2;

import java.io.File;
/*
    File类获取功能的方法
        - public String getAbsolutePath() ：返回此File的绝对路径名字符串。
        - public String getPath() ：将此File转换为路径名字符串。
        - public String getName()  ：返回由此File表示的文件或目录的名称。
        - public long length()  ：返回由此File表示的文件的长度。
 */
public class MyFileDemo2 {

    public static void main(String[] args) {


        System.out.println("获取功能");

        show2();
    }

    /*
    File类判断功能的方法
        - public boolean exists() ：此File表示的文件或目录是否实际存在。
        - public boolean isDirectory() ：此File表示的是否为目录。
        - public boolean isFile() ：此File表示的是否为文件。
 */
    // 判断

    public static void show2(){

        File file =  new File("C:\\Users\\codertom\\Desktop\\code\\note\\IDEA.txt");

        boolean isE = file.exists();
        System.out.println(isE);
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }

    // 获取
    public static void show1(){

        File file =  new File("C:\\Users\\codertom\\Desktop\\code\\note\\IDEA.txt");

        long length = file.length();

        System.out.println(length);// 333字节
        System.out.println(file.getName());
    }




}
