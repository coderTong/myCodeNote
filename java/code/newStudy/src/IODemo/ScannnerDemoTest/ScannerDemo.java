package IODemo.ScannnerDemoTest;

import java.io.File;
import java.util.Scanner;

/**
 * Created by codew on 2018/1/28.
 */

// 扫描器类
public class ScannerDemo {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(new File("file/stream.txt"), "UTF-8");
        while (sc.hasNextLine()){

            String line = sc.nextLine();
            System.out.println(line);
        }

        sc.close();

    }
}
