package com.codertomwu.MyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MyExceptionMain {

    public static void main(String[] args) throws Exception {


        // 编译异常示例
//        SimpleDateFormat  sdf = new SimpleDateFormat("yy-MM-dd");
//        Date date = null;
//        try {
//            date = sdf.parse("18-11-03");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
//
//
//        // 运行时
//        int[] arr = {1,2,3};
////        System.out.println(arr[3]);
//
//
//        int[] arr2 = null;
//        getElement(arr2,2);

        excepationT3();

    }


    public static int  getElement(int[] arr, int index) throws Exception{

        if (arr == null){

            throw new NullPointerException("传递的数组的值是null");
        }
        int ele = arr[index];

        return ele;
    }




    public static void excepationT1(){

        try {
            int[] arr = {1,2,3};
            System.out.println(arr[3]);
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println(e);
        }

        try {
            List<Integer> list = List.of(1,2,3);
            System.out.println(list.get(3));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
// 多个异常分别处理
    public static void excepationT2(){

        try {

            int[] arr = {1,2,3};
            System.out.println(arr[3]);

            List<Integer> list = List.of(1,2,3);
            System.out.println(list.get(3));
            /**
             * 异常有子父类关系子类必须写父类上面
             * ArrayIndexOutOfBoundsException继承IndexOutOfBoundsException
             * 所以ArrayIndexOutOfBoundsException写前面
             * */
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }

    }


//    2.多个异常一次捕获，多次处理。

    public static void excepationT3(){

        try {

            int[] arr = {1,2,3};
            System.out.println(arr[3]);

            List<Integer> list = List.of(1,2,3);
            System.out.println(list.get(3));

        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }

    }


}
