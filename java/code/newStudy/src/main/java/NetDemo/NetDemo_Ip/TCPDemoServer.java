package NetDemo.NetDemo_Ip;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codew on 2018/1/28.
 */
public class TCPDemoServer {

    public static void main(String[] args) throws Exception{

        String data = "嗨喽, 来就来呗, 还带啥东西啊.  ";
        ServerSocket server = new ServerSocket(8999);
        System.out.println("服务端已经准备好了....");

        boolean result = true;
        while (result){
            // 接受连接该服务器的客户端对象
            Socket client = server.accept();
            System.out.println( "连接过来的客户端:" + client.getInetAddress() );

            // 获取该客户端的输出流对象, 给该客户端输出数据
            PrintStream out = new PrintStream(client.getOutputStream());
            out.println(data);

            out.close();
        }
        server.close();
    }
}
