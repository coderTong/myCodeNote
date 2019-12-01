package FileTestDemo;

import java.io.File;
import java.util.List;

/**
 * Created by codew on 2018/1/24.
 */


public class FileDemo1 {



    public static void main(String[] args)
    {

        File f1 = new File("/Users/codew/Desktop/Test/AAC/abc.m");
        File f2 = new File("/Users/codew/Desktop/Test/AAC", "abc.m");

        File dir = new File("/Users/codew/Desktop/Test/AAC");
        File f3 = new File(dir, "abc.m");
        System.out.println(f1);

        List list = null;

    }
    @Deprecated
    public void show1(){

    }



}
