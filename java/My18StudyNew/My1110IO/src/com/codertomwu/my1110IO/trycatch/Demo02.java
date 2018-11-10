package com.codertomwu.my1110IO.trycatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */

/*
    JDK7的新特性
    在try的后边可以增加一个(),在括号中可以定义流对象
    那么这个流对象的作用域就在try中有效
    try中的代码执行完毕,会自动把流对象释放,不用写finally
    格式:
        try(定义流对象;定义流对象....){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }
 */


public class Demo02 {

    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("IOTestInput/girl.png");
             FileOutputStream fileOutputStream = new FileOutputStream("IOTestInput/girl2.png")){

            int len = 0;
            byte[] bytes = new byte[1024];

            while ((len = fileInputStream.read(bytes)) != -1){

                fileOutputStream.write(bytes,0,len);
            }


        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
