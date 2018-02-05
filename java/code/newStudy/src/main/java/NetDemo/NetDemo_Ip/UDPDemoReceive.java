package NetDemo.NetDemo_Ip;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by codew on 2018/1/29.
 */
public class UDPDemoReceive {

    public static void main(String[] args) throws Exception{

        DatagramSocket recevier = new DatagramSocket(10010);
        byte[] buffer = new byte[1024];

        DatagramPacket dp = new DatagramPacket(buffer, 1024);
        recevier.receive(dp);

        String msg = new String(dp.getData(), 0, dp.getLength());
        System.out.println("接收到数据:" + msg);
    }
}
