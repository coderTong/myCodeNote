package MainExceptionDemo;

import java.io.FileNotFoundException;

public class MyExceptionTryDemo {


    public static void main(String[] args) {

        read3();
    }



    /**
     *这种异常处理方式，要求多个catch中的异常不能相同，并且若catch中的多个异常之间有子父类异 常的关系，那么子类异常要求在上面的catch处理，父类异常在下面的catch处理。
     *
     * 运行时异常被抛出可以不处理。即不捕获也不声明抛出。
     * 如果finally有return语句,永远返回finally中的结果,避免该情况.
     * 如果父类抛出了多个异常,子类重写父类方法时,抛出和父类相同的异常或者是父类异常的子类或者不抛出异 常。
     * 父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不
     *   能声明抛出
     * */

    public static void read3(){

        try {

            read("a.txt");

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }finally {

            System.out.println("不管程序怎样, 这里都会执行.");
        }

        System.out.println("over");

    }





    /***
     *
     * 注意:try和catch都不能单独使用,必须连用。
     */

    public static void read2Try()
    {

        try {

            read2("b.txt");
        } catch (FileNotFoundException e) {

            System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("over");
    }

    public static void read2(String path) throws FileNotFoundException {

        if (!path.equals("a.txt")){

            throw new FileNotFoundException("文件不存在2");
        }


    }

    /* *
     * 我们 当前的这个方法中 有异常 有编译期异常
     */
    public static void read(String path) throws FileNotFoundException { if (!path.equals("a.txt")) {//如果不是 a.txt这个文件
// 我假设 如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常 throw
        throw new FileNotFoundException("文件不存在"); }
    }
}
