package IODemo.MemoryArray;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by codew on 2018/1/27.
 */
public class StringWriteReaderDemo {

    public static void main(String[] args) throws Exception
    {

        // 字符串的输出流
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("今天天气真好");
        stringWriter.write("确实不错");

        System.out.println(stringWriter.toString());


        // 字符串的输入流
        StringReader stringReader = new StringReader(stringWriter.toString());


        char[] buffer = new char[1024];
        int len = -1;
        while ((len = stringReader.read(buffer)) != -1){

            System.out.println((char)len);
        }
        stringWriter.close();
    }
}
