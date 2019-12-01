package IODemo.PrintDemo;

import java.io.File;
import java.io.PrintStream;

/**
 * Created by codew on 2018/1/28.
 */
public class PrintStreamDemo {

    public static void main(String[] args) throws Exception{

        PrintStream ps = new PrintStream(new File("file/out"));
        ps.write("ABCD".getBytes());
        ps.print(true);
        ps.print(17);
        ps.print("will");

        ps.close();
    }
}
