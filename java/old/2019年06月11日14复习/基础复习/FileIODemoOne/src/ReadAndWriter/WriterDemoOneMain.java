package ReadAndWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemoOneMain {

    public static void main(String[] args) throws IOException {


        writerArrayTest();

    }

    private static void writerArrayTest() throws IOException {

        FileWriter writer = new FileWriter("pp.properties", true);



        writer.write("name=张三");
        writer.write("age=15");
        writer.write("class=初三");

        writer.close();

    }


    private static void writerArray() throws IOException {

        FileWriter writer = new FileWriter("fw.txt", true);

        char[] chars = " 今晚吃鸡 ".toCharArray();

        writer.write(chars);

        writer.write("\n");
        writer.write(chars, 2, 2);

        writer.close();

    }

    private static void writer001() throws IOException {

        FileWriter writer = new FileWriter("fw.txt", true);

        writer.write(97);
        writer.write('b');
        writer.write('c');
        writer.write(30000); //// 写出第4个字符，中文编码表中30000对应一个汉字。



        /**
         * 2019年06月19日17:47:57
         * 因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据 的。如果我们既想写出数据，又想继续使用流，就需要 flush 方法了。
         * flush :刷新缓冲区，流对象可以继续使用。
         * close :先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
         * */
         /* 【注意】关闭资源时,与FileOutputStream不同。
            如果不关闭,数据只是保存到缓冲区，并未保存到文件。 */

//        writer.flush();
        writer.close();


    }
}
