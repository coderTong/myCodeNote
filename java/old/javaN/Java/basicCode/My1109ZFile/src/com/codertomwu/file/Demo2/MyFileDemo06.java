package com.codertomwu.file.Demo2;

import java.io.File;
import java.io.FileFilter;

public class MyFileDemo06 {

    public static void main(String[] args) {

        File dir =  new File("C:\\Users\\codertom\\Desktop\\code\\Java\\basicCode");
        print3(dir);
    }

    public static void print3(File dir){

        File[] files = dir.listFiles(f ->{
            return f.getName().endsWith(".java") || f.isDirectory();
        });

        for (File file: files) {

            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            }else {
                print3(file);
            }
        }
    }
    public static void print2(File dir){

        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java") || pathname.isDirectory();
            }
        });


        for (File file: files) {

            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            }else {
                print2(file);
            }
        }
    }
}

