package FileTestDemo;

import java.io.File;

/**
 * Created by codew on 2018/1/24.
 */
public class FileDemo3 {

    public static void main(String[] args)
    {
        File f = new File("/Users/codew/Desktop/Test/AAC/");

        listAllFile(f);
    }

    private static void listAllFile(File f)
    {
        File[] fs = f.listFiles();

        for (File flie: fs) {

            System.out.println(flie);

            if (flie.isDirectory()){

                listAllFile(flie);
            }
        }

    }


    // 文件过滤器


}
