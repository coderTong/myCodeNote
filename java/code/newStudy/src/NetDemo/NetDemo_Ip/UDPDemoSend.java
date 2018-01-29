package NetDemo.NetDemo_Ip;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by codew on 2018/1/29.
 */
public class UDPDemoSend {

    public static void main(String[] args) throws Exception{

        String data = "今天天气不错哟.";
        DatagramSocket sender = new DatagramSocket(10010);

        DatagramPacket dp = new DatagramPacket(data.getBytes(),
                data.getBytes().length,
                InetAddress.getLocalHost(),
                10010);

        sender.send(dp);
        sender.close();
    }
}
