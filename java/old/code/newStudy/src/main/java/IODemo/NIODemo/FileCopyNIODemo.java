package IODemo.NIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by codew on 2018/1/28.
 */
public class FileCopyNIODemo {

    public static void main(String[] args) throws Exception{

        Files.copy(Paths.get("file/stream.txt"), new FileOutputStream("file/NIOTest1.txt"));

        Files.copy(new FileInputStream("file/stream.txt"), Paths.get("file/cccNIO.txt"));
    }
}
