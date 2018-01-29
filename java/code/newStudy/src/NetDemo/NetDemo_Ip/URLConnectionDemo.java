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
