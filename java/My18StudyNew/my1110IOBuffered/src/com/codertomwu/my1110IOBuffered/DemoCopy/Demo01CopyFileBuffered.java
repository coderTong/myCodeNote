package com.codertomwu.my1110IOBuffered.DemoCopy;

import java.io.*;

/**
 * Created by codew on 11/10/18.
 */
public class Demo01CopyFileBuffered {

    public static void main(String[] args) throws IOException {

        long s = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("BufferedIO/test.exe");
        FileOutputStream outputStream =  new FileOutputStream("BufferedIO/1.exe");

        BufferedInputStream bufferedInputStream  = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);



        byte[] bytes = new byte[1024];
        int len = 0;

        while ((len = bufferedInputStream.read(bytes)) != -1){

            bufferedOutputStream.write(bytes,0,len);

        }



        bufferedInputStream.close();
        bufferedOutputStream.close();
        long e = System.currentTimeMillis();
        System.out.println("耗时:" + (e-s) + "毫秒");

    }
}
