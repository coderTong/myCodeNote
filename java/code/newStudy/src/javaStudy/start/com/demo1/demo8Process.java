package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

/**
 * 开启一个进程
 * */
public class demo8Process {

    public static void main(String[] args) throws Exception
    {

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepd");

        // 使用
        ProcessBuilder pb = new ProcessBuilder("notepd");
        pb.start();
    }
}
