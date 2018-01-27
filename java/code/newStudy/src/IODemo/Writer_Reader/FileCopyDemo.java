package IODemo.Writer_Reader;

import java.io.*;

/**
 * Created by codew on 2018/1/25.
 */
public class FileCopyDemo {


    public static void main(String[] args) throws Exception {

        // 1. 创建源
        File srcFile = new File("file/xx.txt");
        File desFile = new File("file/ch_copy.txt");

        // 2. 创建输出和输出流对象
        Reader in = new FileReader(srcFile);
        Writer out = new FileWriter(desFile);

        // 3. 读写操作
        char[] buffer = new char[100];
        int len = -1;

        while ( (len = in.read(buffer)) != -1){

            out.write(buffer, 0, len);
        }

        // 4.关闭资源
        out.close();
        in.close();
    }
}
