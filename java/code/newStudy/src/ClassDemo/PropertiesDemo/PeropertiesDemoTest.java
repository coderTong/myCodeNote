package ClassDemo.PropertiesDemo;

import IODemo.PropertiesDemoTest.LoadResourceDemo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by codew on 2018/1/30.
 */

public class PeropertiesDemoTest {

    public static void main(String[] args) throws Exception{

        test3();

    }

    // 第一种是绝对路径
    private static void test1() throws Exception{


        Properties p = new Properties();
        InputStream inputStream = new FileInputStream("/Users/codew/Desktop/code/Net/github/myCodeNote/java/code/newStudy/resources/db.properties");

        p.load(inputStream);
        System.out.println(p);
    }

    private static void test2() throws  Exception{

        System.out.println("test2");

        Properties p = new Properties();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        loader = LoadResourceDemo.class.getClassLoader();

        InputStream inputStream = loader.getResourceAsStream("db.properties");
        p.load(inputStream);

        System.out.println(p);
    }

    private static void test3() throws Exception{

        System.out.println("test3 ===============?>");

        Properties p = new Properties();
        InputStream inputStream = LoadResourceDemo.class.getResourceAsStream("");

        p.load(inputStream);
        System.out.println(p);
    }
}
