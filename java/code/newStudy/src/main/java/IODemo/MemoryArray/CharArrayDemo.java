package IODemo.MemoryArray;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

/**
 * Created by codew on 2018/1/27.
 */

// 字符内存流/字符数组流
public class CharArrayDemo {

    public static void main(String[] args) throws Exception
    {

        // 字符数组输出流
        CharArrayWriter writer = new CharArrayWriter(128);
        writer.write("哈哈哈哈");
        char[] data = writer.toCharArray();

        // 字符数组输入流
        CharArrayReader reader = new CharArrayReader(data);


        int len = -1;

        while ( (len = reader.read()) != -1){

            System.out.println( (char)len);
            len = reader.read();
        }

    }
}
