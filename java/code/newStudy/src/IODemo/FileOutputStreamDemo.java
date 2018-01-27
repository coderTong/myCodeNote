package IODemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by codew on 2018/1/25.
 */

// 文件字节输出流Demo
public class FileOutputStreamDemo {

    public static void main(String[] args) throws Exception
    {

        // 1. 创建源和目标
        File target = new File("file/stream.txt");
        //2. 创建文件字节输出流对象 (水管)
        OutputStream out = new FileOutputStream(target, true); // 表示追加
        // 3.具体的输出操作
        /*
        out.write(65); // 把一个字节写入到文件中
        void write(byte b[]); // 把数组写入文件
        void write(byte b[], int off, int len) // 把数组中从off索引开始写len个字节
        */
        out.write("OpenGL shader hello".getBytes(), 0, 15);
        // 4.关闭资源对象,关闭水管
        out.close();

    }
}
