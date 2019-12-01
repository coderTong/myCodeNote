package IODemo.Buffer;

import java.io.*;
import java.util.Properties;

/**
 * Created by codew on 2018/1/27.
 */
public class TransformDemo {

    public static void main(String[] args) throws Exception
    {

        Properties p = System.getProperties();
        System.out.println(p.get("sun.jnu.encoding"));



        // 1. 创建源和目标
        File srcFile = new  File("file/stream.txt");
        File destFile = new  File("file/TransformDemo2.txt");

        // 2. 创建输入管道(输入/输出流对象)
//        InputStream in = new FileInputStream(srcFile);
//        OutputStream out = new FileOutputStream(destFile);

        Reader in = new InputStreamReader(new FileInputStream(srcFile), "UTF-8");
        Writer out = new OutputStreamWriter( new FileOutputStream(destFile), "UTF-8" );


        // 3.读取/写出操作
        char[] buffer = new char[1024];

        int len = -1;
        while ( (len = in.read(buffer)) != -1 )
        {
            out.write(buffer, 0, len);
        }
        // 4.关闭管道
        in.close();
        out.close();
    }
}
