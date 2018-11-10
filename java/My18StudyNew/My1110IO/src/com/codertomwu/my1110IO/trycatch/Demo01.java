package com.codertomwu.my1110IO.trycatch;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */

/*
    在jdk1.7之前使用try catch finally 处理流中的异常
    格式:
        try{
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }finally{
            一定会指定的代码
            资源释放
        }
 */
public class Demo01 {

    public static void main(String[] args) {



        //提高变量fw的作用域,让finally可以使用
        //变量在定义的时候,可以没有值,但是使用的时候必须有值
        //fw = new FileWriter("FileWriter/text2.txt",true); 执行失败,fw没有值,fw.close会报错

        //FileWriter/text2.txt

        FileWriter fw = null;

        try {

            fw = new FileWriter("FileWriter2/text3.txt",true);
        }catch (IOException e){

            System.out.println(e);
        }finally {

            // 一定会指定的代码
            // //创建对象失败了,fw的默认值就是null,null是不能调用方法的,会抛出NullPointerException,需要增加一个判断,不是null在把资源释放

            if (fw!=null){

                try {
                    fw.close();
                }catch (IOException e){

                    e.printStackTrace();
                }
            }
        }
    }
}
