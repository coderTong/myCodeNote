package IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by codew on 2018/1/25.
 */
public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception
    {

        // 1. 创建源
        File f = new File("file/stream.txt");

        // 2. 创建文件字节输入流对象, 并接在源上

        InputStream in = new FileInputStream(f);

        // 3. 具体的读取操作
        /*
         int read(); // 一个字节一个字节的读取
         int read(byte[] b); // 读取多个字节,并存储到数组b中,从数组b的索引为o的位置开始存,返回读取了几个字节
         int read(byte[] b, int off, int len);
        */
        // 3.1
//        int value = in.read();
//
//        while (value != -1){
//
//            System.out.println(value);
//            value = in.read();
//        }

        // 3.2

        byte[] buffer = new byte[10];

        int ret = in.read(buffer);
//        System.out.println(Arrays.toString(buffer));
        while (ret != -1)
        {
            System.out.println(Arrays.toString(buffer));
            buffer = new byte[10];
            ret = in.read(buffer);

        }

        // 4. 关闭资源
        in.close();
    }
}
