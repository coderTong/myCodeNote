package FileTestDemo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by codew on 2018/1/24.
 */
public class FileDemo4 {

    public static void main(String[] args)
    {
        File f = new File("/Users/codew/Desktop/Test/AAC/");

        File[] fs = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return new File(f, name).isFile() && name.endsWith(".java");

            }
        });

        for (File file: fs
             ) {

            System.out.println(file);

        }
    }
}
