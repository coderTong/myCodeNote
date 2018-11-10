package com.codertomwu.my1110IOBuffered.DemoCopy;

import java.io.*;

/**
 * Created by codew on 11/10/18.
 */
public class Demo01CopyFile {

    public static void main(String[] args) throws IOException {

        long s = System.currentTimeMillis();


        FileInputStream fileInputStream = new FileInputStream("BufferedIO/test.exe");
        FileOutputStream outputStream =  new FileOutputStream("BufferedIO/2.exe");


        byte[] bytes = new byte[1024];
        int len = 0;

        while ((len = fileInputStream.read(bytes)) != -1){

            outputStream.write(bytes,0,len);


        }


        fileInputStream.close();
        outputStream.close();
        long e = System.currentTimeMillis();
        System.out.println("耗时:" + (e-s) + "毫秒");




    }
}
