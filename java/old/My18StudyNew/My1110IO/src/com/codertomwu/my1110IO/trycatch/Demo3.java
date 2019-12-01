package com.codertomwu.my1110IO.trycatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */

/*
    JDK9新特性
    try的前边可以定义流对象
    在try后边的()中可以直接引入流对象的名称(变量名)
    在try代码执行完毕之后,流对象也可以释放掉,不用写finally
    格式:
        A a = new A();
        B b = new B();
        try(a,b){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }
 */
public class Demo3 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("IOTestInput/girl.png");
        FileOutputStream fileOutputStream = new FileOutputStream("IOTestInput/girl3.png");

        // JAVA9的
//        try (fileInputStream;fileOutputStream){
//
//
//            int len = 0;
//            while ((len = fileInputStream.read()) != -1){
//
//                fileOutputStream.write(len);
//            }
//
//        }catch (IOException e){
//
//            System.out.println(e);
//        }
    }
}
