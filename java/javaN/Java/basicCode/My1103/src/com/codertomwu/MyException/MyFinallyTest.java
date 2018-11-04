package com.codertomwu.MyException;

// 如果finally有return 语句， 永远返回finally中 的结果， 并避免
public class MyFinallyTest {


    public static void main(String[] args) {


        System.out.println(getNum());
    }

    public static int getNum(){

        int a = 20;

//        return a;
        try {
            int[] arr = {1,2,3};
            System.out.println(arr[3]);
        }catch (Exception e){

        }finally {

            a = 33;
            return a;
        }

    }
}
