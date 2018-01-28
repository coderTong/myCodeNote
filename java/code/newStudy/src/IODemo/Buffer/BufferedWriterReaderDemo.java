package IODemo.Buffer;

import java.io.*;

/**
 * Created by codew on 2018/1/25.
 */
public class BufferedWriterReaderDemo {

    public static void main(String[] args) throws Exception
    {

        // 字符缓冲流输出
        BufferedWriter out = new BufferedWriter( new FileWriter("file/stream.txt"));
        out.write("君不见黄河之上天上来");
        out.newLine();
        out.write("奔流到海不复回");
        out.close();

        // 字符缓冲流输入

        BufferedReader reader = new BufferedReader(new FileReader("file/stream.txt"));
//        char[] buffer = new char[1024];
//        int len = -1;
//        while ((len = reader.read(buffer)) != -1){
//
//            System.out.println( new String(buffer, 0, len));
//        }
        String line = null;
        while ( (line = reader.readLine()) != null ){

            System.out.println(line);
        }


        reader.close();
    }
}
