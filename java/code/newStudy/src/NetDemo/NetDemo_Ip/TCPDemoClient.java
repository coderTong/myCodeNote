package NetDemo.NetDemo_Ip;

import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codew on 2018/1/28.
 */
public class TCPDemoClient {

    public static void main(String[] args) throws Exception{

        // 创建客户端对象, 并指明连接服务端的主机端口
        Socket client = new Socket("localhost", 8999);

        // 获取客\客户端的输入流对象
        Scanner sc = new Scanner( client.getInputStream() );
        while (sc.hasNextLine()){

            String line = sc.nextLine();
            System.out.println(line);
        }

        sc.close();
        client.close();
    }
}
