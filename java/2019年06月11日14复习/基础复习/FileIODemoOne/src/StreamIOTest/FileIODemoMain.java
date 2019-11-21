package StreamIOTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIODemoMain {

    public static void main(String[] args) throws IOException {

        writerTestArrayH();

    }





    /**
     * 换行测试
     * 2019年06月19日16:18:32
     * 钢哥: 我寻思今年投资赚个5万，现在还差8万
     * 我: 我还寻思能炒出个新手机钱, 哪知道赔了个手机钱
     *
     *
     * */
    private static void writerTestArrayH() throws IOException {


        FileOutputStream fos = new FileOutputStream("fca.txt", true);

        byte[] b = {97, 98, 100, 101};

        for (int i = 0; i < b.length; i++) {


            fos.write(b[i]);

            fos.write("\n".getBytes());
        }

        fos.write(b);

        fos.close();
    }


    /**
     * 2019年06月19日16:02:01
     * 数据追加
     * 构造方法
     * 东方能源 +3.24%
     * 一汽夏利 +32.67%
     * 就手头回本了
     *
     * */
    private static void writerTestArrayAppend() throws IOException {

        FileOutputStream fos = new FileOutputStream("fc.txt", true);

        byte[] b = "abcd".getBytes();

        fos.write(b);

        fos.close();
    }


    /**
     * 2019年06月19日15:56:32
     * 所以今天很尴尬, 实力一点点累积中, 一行代码一块钱, 一天赚了'
     *
     * 写出指定长度字节数组: write(byte[] b, int off, int len) ,每次写出从off索引开始，len个字节，代码 使用演示:
     * */
    private static void writerTestArrayLenghtAndIndex() throws IOException {

        FileOutputStream fos = new FileOutputStream("fc.txt");

        //
//        byte[] b = "我是尬王之王".getBytes();

        // 一个汉字3个字节?
        byte[] b = "我是尬王之王".getBytes();

        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b,3,6);
        fos.close();

    }


    private static void writerTestArray() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("fox.txt");

        byte[] a = "昨天吃黄焖鸡".getBytes();

        fileOutputStream.write(a);

        fileOutputStream.close();

    }


    private static void writerTest1() throws IOException {


        FileOutputStream fileOutputStream = new FileOutputStream("fos.txt");

        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);
        fileOutputStream.write(96);
        fileOutputStream.write(95);
        fileOutputStream.close();
    }


    private static void createTest() throws FileNotFoundException {

        File file = new File("a.txt");

        System.out.println(file.getAbsolutePath());

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        FileOutputStream fileOutputStream1 = new FileOutputStream("b.txt");
    }
}
