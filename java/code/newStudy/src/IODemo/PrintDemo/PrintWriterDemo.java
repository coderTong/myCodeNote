package IODemo.PrintDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by codew on 2018/1/28.
 */
public class PrintWriterDemo {

    public static void main(String[] args) throws Exception{

//        PrintWriter ps = new PrintWriter(new File("file/out"));
        PrintWriter ps = new PrintWriter( new FileOutputStream(new File("file/out")), true);
        ps.write("ABCDCCCC");
        ps.print(true);
        ps.print(17);
        ps.print("will---00000090909");

//        ps.println();// 要配合着 autoFlush:true, 才有用
//        ps.format("");// 要配合着 autoFlush:true, 才有用
//        ps.flush(); // 这个就不用说了...
//        ps.close();
    }
}
