package StreamIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {


        readloop2value();
    }


    /**
     * 2019年06月19日16:54:24
     * 使用字节数组读取: read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读
     * 取到末尾时，返回 -1 ，代码使用演示:
     * */

    private static void readloop2value() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("b.txt");

        int len;

        byte[] b = new byte[2];

        while (  (len = fileInputStream.read(b)) != -1 ){

            System.out.println(new String(b));
        }


//        while (  (len = fileInputStream.read(b)) != -1 ){
//
//            System.out.println(new String(b, 0, len));
//        }

        fileInputStream.close();
    }


    /**
     * 2019年06月19日16:51:44
     * 循环读取
     *
     * */

    private static void readloop() throws IOException {

        FileInputStream fis = new FileInputStream("b.txt");


        int read;

        while ( (read = fis.read() ) != -1 ){

            System.out.println((char)read);
        }

        fis.close();

    }
    private static void read001() throws IOException {

        FileInputStream fis = new FileInputStream("b.txt");

        int read = fis.read();
        System.out.println( (char) read);


        read = fis.read();
        System.out.println( (char) read);

        read = fis.read();
        System.out.println( (char) read);

        read = fis.read();
        System.out.println( (char) read);

        read = fis.read();
        System.out.println( (char) read);

        read = fis.read();
        System.out.println( (char) read);

        fis.close();

    }


    /**
     *
     * 2019年06月19日16:25:09
     * 创建
     *
     * */

    private static void createTest() throws IOException {

        File file = new File("a.txt");
        FileInputStream fos = new FileInputStream(file);

        FileInputStream fos2 = new FileInputStream("fc.txt");

    }
}
