package IODemo;

import java.io.*;

/**
 * Created by codew on 2018/1/25.
 */
public class StreamCopyDemo {

    public static void main(String[] args) throws Exception
    {
        test3();
    }

    private static void test0() throws Exception
    {
        // 1. 创建源和目标
        File srcFile = new  File("file/stream.txt");
        File destFile = new  File("file/stream_copy2.txt");

        // 2. 创建输入管道(输入/输出流对象)
        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);

        // 3.读取/写出操作
        byte[] buffer = new byte[10];

        int len = -1;

        while ( (len = in.read(buffer)) != -1 )
        {
            out.write(buffer, 0, len);
        }
        // 4.关闭管道
        in.close();
        out.close();
    }

    private static void test1()
    {
        // 声明资源对象

        InputStream in = null;
        OutputStream out = null;

        try {

            File srcFile = new  File("file/stream.txt");
            File destFile = new  File("file/stream_copy2.txt");
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);

            byte[] buffer = new byte[10];

            int len = -1;

            while ( (len = in.read(buffer)) != -1 )
            {
                out.write(buffer, 0, len);
            }

        }catch (Exception e){

            e.printStackTrace();

        }finally {



            // 4.关闭管道
            try {

                if (in != null){

                    in.close();
                }

            }catch (Exception e){

                e.printStackTrace();
            }

            try {

                if (out != null){
                    out.close();
                }

            }catch (Exception e){

                e.printStackTrace();
            }

        }

    }

    // Java7 提供的自动资源关闭
    private static void test3()
    {
        File srcFile = new  File("file/stream.txt");
        File destFile = new  File("file/stream_copy5.txt");

        try (   InputStream in = new FileInputStream(srcFile);
                OutputStream out = new FileOutputStream(destFile);
                ){

            byte[] buffer = new byte[10];
            int len = -1;

            while ( (len = in.read(buffer)) != -1 ){

                out.write(buffer, 0, len);
            }

        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
