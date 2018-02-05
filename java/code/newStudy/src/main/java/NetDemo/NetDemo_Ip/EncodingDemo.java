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
