package IODemo.Writer_Reader;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by codew on 2018/1/25.
 */


public class FileWriteDemo {

    public static void main(String[] args) throws Exception {

//        File

        // 1. 创建目标
        File destFile = new File("file/xx.txt");


        // 2. 创建字符输出流对象

        Writer out = new FileWriter(destFile);

        // 3.具体操作, 写操作
        /*
        void write(int c); // 向外写出一个字符
        void write(char cbuf[]);
        void write(char cbuf[], int off, int len);
        void write(String str);
        */
//        out.write('s');
//        out.write("opengl".toCharArray());
        //out.write("opengl".toCharArray(), 3, 2);
        out.write("opengl");

//        out.flush();
        // 4. 关闭流
        out.close();

    }
}
