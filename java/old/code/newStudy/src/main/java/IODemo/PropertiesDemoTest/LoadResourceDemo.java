package IODemo.PropertiesDemoTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by codew on 2018/1/28.
 */
public class LoadResourceDemo {

    public static void main(String[] args) throws Exception{

        // 创建Properties对象
        Properties p = new Properties();
        InputStream inputStream = new FileInputStream("/Users/codew/Desktop/code/Net/github/myCodeNote/java/code/newStudy/file/db.properties");
        // 加载输入流中的数据, 加载之后, 数据都在Properties对象中
        p.load(inputStream);


        System.out.println(p);
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));
        inputStream.close();
    }
}
