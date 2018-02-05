package IODemo.Buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by codew on 2018/1/25.
 */
public class BufferedStreamDemo {

    public static void main(String[] args) throws Exception
    {
        // 字节缓冲输出流

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("stream.txt", true));
        bos.write("hello opengl shader, Metal".getBytes());
        bos.close();

        // 字节缓冲输入流
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream("stream.txt"));
        byte[] buffer = new byte[1024];
        int len = -1;

        len = bin.read(buffer);
        while (len != -1){

            System.out.println(new String(buffer, 0, len));
            len = bin.read(buffer);
        }
        bin.close();
    }
}
