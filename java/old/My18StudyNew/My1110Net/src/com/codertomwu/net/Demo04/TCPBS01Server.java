package com.codertomwu.net.Demo04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codew on 11/11/18.
 */
public class TCPBS01Server {

    public static void main(String[] args) throws IOException {

        ServerSocket  serverSocket = new ServerSocket(8080);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = bufferedReader.readLine();

        String[] arr  = line.split(" ");
        String htmlPath = arr[1].substring(1);

        FileInputStream fileInputStream = new FileInputStream(htmlPath);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        outputStream.write("Content-Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        outputStream.write("\r\n".getBytes());


        int len = 0;
        byte[] bytes = new byte[1024];

        while ((len = fileInputStream.read(bytes)) != -1){

            outputStream.write(bytes, 0, len);
        }

        fileInputStream.close();;
        outputStream.close();
        serverSocket.close();
    }
}
