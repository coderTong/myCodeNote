package IODemo.MemoryArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by codew on 2018/1/27.
 */
public class ByteArrayDemo {

    public static void main(String[] args) throws Exception
    {
        // 字节数组输出流: 程序 ---> 内存

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write("ABCDEe".getBytes());

        // 要使用存储的临时数据
        byte[] buffer = bos.toByteArray();

        // 字节数组输入流: 内存---->程序
        ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
        byte[] bys = new byte[5];
        int len = -1;

        while ( (len = bis.read(bys)) != -1){

            System.out.println(new String(bys, 0, len));
        }

        bis.close();
        bos.close();
    }
}
