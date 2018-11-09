package com.codertomwu.file.Demo1;

import java.io.File;

public class MyFileDemo1Main {

    public static void main(String[] args) {


        show3(new File("cccc"), "ccccc");
    }




    public static void show3(File parent, String child){


        File file = new File(parent, child);

        System.out.println(file);
    }
    public static void show2(String parent, String child){


        File file = new File(parent, child);

        System.out.println(file);;
    }
    public static void show1(){

        File file = new File("C://ss/s/s");
        System.out.println(file);

    }

}
