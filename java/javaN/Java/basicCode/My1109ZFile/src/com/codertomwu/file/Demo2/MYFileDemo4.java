package com.codertomwu.file.Demo2;


import java.io.File;

/*
    File类遍历(文件夹)目录功能
        - public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
        - public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。

    注意:
        list方法和listFiles方法遍历的是构造方法中给出的目录
        如果构造方法中给出的目录的路径不存在,会抛出空指针异常
        如果构造方法中给出的路径不是一个目录,也会抛出空指针异常
 */
public class MYFileDemo4 {


    public static void main(String[] args) {

//        File file = new File("C:\\Users\\codertom\\Desktop\\test\\cc\\dd");
//        file.mkdirs();
        show2();
    }

    public static void show1(){

        File file = new File("C:\\Users\\codertom\\Desktop\\test");

        String[] fDArr = file.list();

        for (String str: fDArr) {

            System.out.println(str);
        }

    }
    public static void show2(){

        File file = new File("C:\\Users\\codertom\\Desktop\\test");

        File[] fDArr = file.listFiles();

        for (File f: fDArr) {

            System.out.println(f);
        }

    }
}
