package ReadAndWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemoOneMain {

    public static void main(String[] args) throws IOException {


        readerArray();
    }


    /**
     * 2019年06月19日17:39:12
     * 使用字符数组读取: read(char[] cbuf) ，每次读取b的长度个字符到数组中，返回读取到的有效字符个数， 读取到末尾时，返回 -1 ，代码使用演示:
     *
     * */


    /**
     * 2019年06月19日17:36:42
     *  最简单读取使用 字符流
     *
     * */

    private static void readerArray() throws IOException {

        FileReader reader = new FileReader("fox.txt");

        int len;
        char[] bytes = new char[2];

//        while ( ( len = reader.read(bytes) ) != -1 ){
//
//            System.out.println( new String(bytes) );
//        }

        while ( ( len = reader.read(bytes) ) != -1 ){

            System.out.println( new String(bytes, 0, len) );
        }


        reader.close();


    }
    private static void reader001() throws IOException {


        FileReader fileReader = new FileReader("fox.txt");

        int b;

        while ( (b = fileReader.read()) != -1 ){

            System.out.println( (char)b );
        }


        fileReader.close();
    }
}
