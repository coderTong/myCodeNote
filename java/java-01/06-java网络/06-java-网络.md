
# 网络编程三要素:

- 1):IP地址.
- 2):端口.
- 3):协议:规则,数据传递/交互规则.


# 网络基础

在Java中,使用`InetAddress`类来表示IP地址.

表示本机:

  方式1:本机IP

  方式2:127.0.0.1

  方式3:localhost

## ip

```

package NetDemo.NetDemo_Ip;

import java.net.InetAddress;
import java.util.Properties;

/**
 * Created by codew on 2018/1/28.
 */
public class InetAddressDemo {

    public static void main(String[] args) throws Exception{

        // bogon
//        InetAddress ip = InetAddress.getByName("192.168.1.101");
//        InetAddress ip = InetAddress.getByName("bogon");

        InetAddress ip = InetAddress.getByName("www.baidu.com");

        // 主机名
        System.out.println(ip.getHostName());
        // ip
        System.out.println(ip.getHostAddress());
        // 本地主机
        System.out.println(ip.getLocalHost());
        // 是否可达
//        System.out.println( InetAddress.getLocalHost().isReachable(10000) );
    }

}

```

## 端口

## 协议

## URL和URI

URI:

统一资源标识符（Uniform Resource Identifier，或URI)是一个用于标识某一互联网资源名称的字符串。

包含:主机名,标识符,相对URI.

如:http://java.sun.com:80/j2se/1.3/hello.html

URL:

统一资源定位符是对可以从互联网上得到的资源的位置和访问方法的一种简洁的表示，是互联网上标准资源的地址。

互联网上的每个文件都有一个唯一的URL，它包含的信息指出文件的位置以及浏览器应该怎么处理它。

-----------------------------

在Java中,URI表示一个统一资源的标识符,不能用于定位任何资源,唯一的作用就是解析.

而URL则包含一个可以打开到达该资源的输入流,可以简单理解URL是URI的特例.

-------------------------------------------------------------------------------

简单理解: URI和URL都表示一个资源路径.

创建URL对象:

URL(String protocol, String host, int port, String file)


```

package NetDemo.NetDemo_Ip;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by codew on 2018/1/28.
 */
public class URLConnectionDemo {

    public static void main(String[] args) throws Exception{

        //http://www.ifeng.com
        // http://p0.ifengimg.com/a/2018_04/30de99f224ef1df_size211_w900_h593.jpg
//       URL url = new URL("http", "www.baidu.com", 80, "");
//        URL url = new URL("http", "p0.ifengimg.com", 80, "/a/2018_04/30de99f224ef1df_size211_w900_h593.jpg");

        URL url = new URL("http://p0.ifengimg.com/a/2018_04/f6403351cf91221_size174_w900_h534.jpg");
       // 打开一个连接
        URLConnection conn = url.openConnection();

        // 网络---输入---程序中
        InputStream in = conn.getInputStream();
//        Scanner sc = new Scanner(in);
//
//        while (sc.hasNextLine()){
//
//            String line = sc.nextLine();
//            System.out.println(line);
//        }
//        sc.close();

        Files.copy(in, Paths.get("file/tu2.jpg"));
    }
}

```


## application/x-www-form-urlencoded MIME编码

URLEncoder和URLDecoder用于完成普通字符串和application/x-www-form-urlencoded MIME字符串之间的相互转换.


![06-java-Net-01](image/06-java-Net-01.png)

```

package NetDemo.NetDemo_Ip;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by codew on 2018/1/28.
 */
public class EncodingDemo {

    public static void main(String[] args) throws Exception{

        String name = "周星驰 zhou 18";
        String ret = URLEncoder.encode(name, System.getProperty("file.encoding"));

        System.out.println(ret);

        // 获取平台的默认字符集
        System.out.println(System.getProperty("file.encoding"));

        String msg = URLDecoder.decode(ret, "UTF-8");
        System.out.println(msg);
    }
}

```


编码和解码:

  在Web的浏览器中,不同的浏览器的编码和解码规则是不一样的.

  对于W3C浏览器:遵循W3C组织规范的浏览器,(非IE).

```

    编码:byte[] data = “任小龙”.getByte(String charsetName);

  解码:String str = new String(data, String charsetName);

```

 对于IE浏览器:

```

  编码使用的application/x-www-form-urlencoded MIME机制.

```



# 传输层TCP/UDP

server

```

package NetDemo.NetDemo_Ip;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codew on 2018/1/28. */ public class TCPDemoServer {

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

```

client

```

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

```