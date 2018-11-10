package com.codertomwu.file.Demo2;

import java.io.File;

public class MyFileDemo05 {


    public static void main(String[] args) {

        File dir =  new File("C:\\Users\\codertom\\Desktop\\code\\Java\\basicCode");



        print(dir);
    }

    public static void print(File dir){

        File[] files = dir.listFiles();

        for (File file: files) {

            if (file.isFile()){

                if (file.getName().endsWith(".java")){

                    System.out.println(file);
                }
            }else {

                print(file);
            }

        }
    }
}
