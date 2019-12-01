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
