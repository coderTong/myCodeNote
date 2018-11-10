package com.codertomwu.net.demo2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codew on 11/10/18.
 */

/*
    文件上传案例服务器端:读取客户端上传的文件,保存到服务器的硬盘,给客户端回写"上传成功"

    明确:
        数据源:客户端上传的文件
        目的地:服务器的硬盘 d:\\upload\\1.jpg

    实现步骤:
        1.创建一个服务器ServerSocket对象,和系统要指定的端口号
        2.使用ServerSocket对象中的方法accept,获取到请求的客户端Socket对象
        3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        4.判断d:\\upload文件夹是否存在,不存在则创建
        5.创建一个本地字节输出流FileOutputStream对象,构造方法中绑定要输出的目的地
        6.使用网络字节输入流InputStream对象中的方法read,读取客户端上传的文件
        7.使用本地字节输出流FileOutputStream对象中的方法write,把读取到的文件保存到服务器的硬盘上
        8.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
        9.使用网络字节输出流OutputStream对象中的方法write,给客户端回写"上传成功"
        10.释放资源(FileOutputStream,Socket,ServerSocket)
 */

public class TCPUploadServer {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();

        File dir = new File("uploadTest");

        if (dir.exists() == false){

            dir.mkdir();
        }

//        File file = new File(dir, )

        FileOutputStream fileOutputStream = new FileOutputStream(dir+"/1.png");

        System.out.println("1111111111");

        int len = 0;

        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1){

            fileOutputStream.write(bytes,0,len);
        }

        System.out.println("22222222222222222222222  while死循环打印不到");

        socket.getOutputStream().write("上传成功".getBytes());

        fileOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
