package IODemo.Standard;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by codew on 2018/1/28.
 */
public class SystemIODemoTest {

    public static void main(String[] args) throws Exception{


        // 重定向标准输入流
        System.setIn(new FileInputStream("file/stream.txt"));
        // 重定向标准输出流
        System.setOut(new PrintStream("file/xxIn.txt"));

        System.out.println("----begin----");

        int data = System.in.read();
        System.out.println(data);

        System.out.println("....end....");
    }

    private static void test1() throws IOException
    {
        System.out.println("----begin----");

        int data = System.in.read();
        System.out.println(data);

        System.out.println("....end....");
    }
}
