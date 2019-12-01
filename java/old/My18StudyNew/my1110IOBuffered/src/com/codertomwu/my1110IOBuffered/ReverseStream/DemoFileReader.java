package com.codertomwu.my1110IOBuffered.ReverseStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by codew on 11/10/18.
 */

/*
    FileReader可以读取IDE默认编码格式(UTF-8)的文件
    FileReader读取系统默认编码(中文GBK)会产生乱码���
 */
public class DemoFileReader {

    public static void main(String[] args) throws IOException {


        FileReader  fileReader = new FileReader("BufferedIO/gbk.txt");

        int len = 0;
        while ((len = fileReader.read()) != -1){

            System.out.println((char)len);
        }

        fileReader.close();
    }
}
