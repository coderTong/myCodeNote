package com.codertomwu.my1110IOBuffered.DemoBufferedStream;

import java.io.*;

/**
 * Created by codew on 11/10/18.
 */



public class DemoBufferedStreamMain {

    public static void main(String[] args) throws IOException {

//        bufferedOut();
        bufferedIn();

    }


    /*
    java.io.BufferedInputStream extends InputStream
    BufferedInputStream:字节缓冲输入流

    继承自父类的成员方法:
        int read()从输入流中读取数据的下一个字节。
        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        void close() 关闭此输入流并释放与该流关联的所有系统资源。

    构造方法:
        BufferedInputStream(InputStream in) 创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
        BufferedInputStream(InputStream in, int size) 创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
        参数:
            InputStream in:字节输入流
                我们可以传递FileInputStream,缓冲流会给FileInputStream增加一个缓冲区,提高FileInputStream的读取效率
            int size:指定缓冲流内部缓冲区的大小,不指定默认

    使用步骤(重点):
        1.创建FileInputStream对象,构造方法中绑定要读取的数据源
        2.创建BufferedInputStream对象,构造方法中传递FileInputStream对象,提高FileInputStream对象的读取效率
        3.使用BufferedInputStream对象中的方法read,读取文件
        4.释放资源
 */
    public static void bufferedIn() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("BufferedIO/1.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int len = 0;
//
//        while ((len = bufferedInputStream.read()) != -1){
//
//            System.out.println((char)len);
//        }

        byte[] bytes = new byte[1024];

        while ((len = bufferedInputStream.read(bytes)) != -1){

            System.out.println(new String(bytes,0,len));
        }

        bufferedInputStream.close();


    }


    /*
    java.io.BufferedOutputStream extends OutputStream
    BufferedOutputStream:字节缓冲输出流

    继承自父类的共性成员方法:
        - public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
        - public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
        - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        - public abstract void write(int b) ：将指定的字节输出流。

     构造方法:
        BufferedOutputStream(OutputStream out)  创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
        BufferedOutputStream(OutputStream out, int size)  创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
        参数:
           OutputStream out:字节输出流
                我们可以传递FileOutputStream,缓冲流会给FileOutputStream增加一个缓冲区,提高FileOutputStream的写入效率
           int size:指定缓冲流内部缓冲区的大小,不指定默认
     使用步骤(重点)
        1.创建FileOutputStream对象,构造方法中绑定要输出的目的地
        2.创建BufferedOutputStream对象,构造方法中传递FileOutputStream对象对象,提高FileOutputStream对象效率
        3.使用BufferedOutputStream对象中的方法write,把数据写入到内部缓冲区中
        4.使用BufferedOutputStream对象中的方法flush,把内部缓冲区中的数据,刷新到文件中
        5.释放资源(会先调用flush方法刷新数据,第4部可以省略)
 */

    public static void bufferedOut() throws IOException {

        File dir = new File("BufferedIO");
        if (dir.isDirectory() == false) {

            dir.mkdir();
        }

        FileOutputStream fileOutputStream = new FileOutputStream("BufferedIO/1.txt", true);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        for (int i = 0; i < 5; i++) {


            bufferedOutputStream.write("写个文件看看\n".getBytes());
        }


        bufferedOutputStream.flush();
        bufferedOutputStream.close();


    }


}