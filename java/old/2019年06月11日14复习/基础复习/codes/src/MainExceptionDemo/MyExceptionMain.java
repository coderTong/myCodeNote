package MainExceptionDemo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyExceptionMain {

    public static void main(String[] args) throws IOException {


        read2("a.txt");
    }








    /**
     * throws用于进行异常类的声明，若该方法可能有多种异常情况产生，那么在throws后面可以写多个异常类，用逗 号隔开。
     *
     * */
    public static void read2(String path) throws FileNotFoundException, IOException{


        if (!path.equals("a.txt")){

            throw new FileNotFoundException("文件不存在");

        }

        if (!path.equals("b.txt")){
            throw new IOException();
        }

    }





/**
 * // 如果定义功能时有问题发生需要报告给调用者。可以通过在方法上使用throws关键字进行声明
 *
 * */

    public static void read(String path) throws FileNotFoundException{


        if (path.equals("a.txt")){

            throw new FileNotFoundException("文件不存在");
        }
    }







/**
 * test1 =========================================================================================================
 *
 * */
    public static void test1Exception(){

        int[] arr = {2,4,52,2};

        int index = 4;

        int element = getElement(arr, index);

        System.out.println(element);
        System.out.println("over");
    }



    public static int getElement(int[] arr, int index){

        if (index < 0 || index>arr.length - 1){

            throw new ArrayIndexOutOfBoundsException("角标越界了~~~~~~");
        }

        int element = arr[index];

        return element;

    }
}
