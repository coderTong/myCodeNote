package IODemo.Writer_Reader;

import java.io.File;
import java.io.FileReader;

/**
 * Created by codew on 2018/1/25.
 */

// 文件字符输入流
public class FileReaderDemo {

    public static void main(String[] args) throws Exception {

        // 1. 创建源和目标

        File srcFile = new File("file/stream.txt");

        // 2. 创建操作对象, 字符输入流的对象
        FileReader fileReader = new FileReader(srcFile);
        // 3. 具体操作

        /*

        int reader(); // 每次读取 一个字符
        int reader(char[] cbuf); //
        */

        // 3.1 一个字符一个字符的读
//        int c = fileReader.read();
//        while ( c != -1){
//
//            System.out.println((char)c);
//            c = fileReader.read();
//        }

        // 3.2 多个字符的读
        char[] buffer = new char[5];
        int len = -1;
        len = fileReader.read(buffer);

        while (len != -1){

            System.out.println(buffer);
            len = fileReader.read(buffer);

        }

        // 4. 关闭

        fileReader.close();
    }
}
