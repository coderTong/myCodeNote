package IODemo.Buffer;

import java.io.*;

/**
 * Created by codew on 2018/1/27.
 */
public class NodeStreamVSBufferedStreamDemo {

    public static void main(String[] args) throws Exception
    {

        File srcFile = new File("欧体笔法-01-永字八法(田英章).mp4");
        File destFile = new File("file/test_buffer_BufferedInputStream.mp4");

        test4(srcFile, destFile);
    }




    private static void test1(File srcFile, File destFile) throws Exception
    {
        long begin = System.currentTimeMillis();

        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);

        /**
         * 一个字节一个字节的读取, 画了将近一分半钟
         * */
        int len = -1;
        while ( (len = in.read()) != -1)
        {
            out.write(len);
        }
        out.close();
        in.close();
        System.out.println( System.currentTimeMillis() - begin );
    }


    // 使用缓冲流, 从内存文件中一个字节一个字节的读写 : 花了288毫秒
    private static void test2(File srcFile, File destFile) throws Exception
    {
        long begin = System.currentTimeMillis();

        InputStream in = new BufferedInputStream( new FileInputStream(srcFile));
        OutputStream out = new BufferedOutputStream( new FileOutputStream(destFile));

        int len = -1;
        while ( (len = in.read()) != -1)
        {
            out.write(len);
        }
        out.close();
        in.close();
        System.out.println( System.currentTimeMillis() - begin );
    }

    // 使用节点流, 从磁盘中每次读写1024字节 : 125毫秒
    private static void test3(File srcFile, File destFile) throws Exception
    {
        long begin = System.currentTimeMillis();

        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(destFile);

        byte[] buffer = new byte[1024];
        int len = -1;

        while ( (len = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        System.out.println( System.currentTimeMillis() - begin );
    }


    // 使用缓冲流, 从内存文件中每次读写1024字节: 41毫秒
    private static void test4(File srcFile, File destFile) throws Exception
    {
        long begin = System.currentTimeMillis();

        InputStream in = new BufferedInputStream( new FileInputStream(srcFile));
        OutputStream out = new BufferedOutputStream( new FileOutputStream(destFile));

        byte[] buffer = new byte[1024];
        int len = -1;

        while ( (len = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, len);
        }

        out.close();
        in.close();
        System.out.println( System.currentTimeMillis() - begin );
    }
}
