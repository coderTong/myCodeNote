package IODemo.DataDemoTest;

import java.io.*;

/**
 * Created by codew on 2018/1/28.
 */


public class DataStreamDemo {


    public static void main(String[] args) throws Exception{

        File f = new File("file/outData.txt");
        write(f);
        read(f);
    }

    private static void read(File f) throws Exception
    {
        DataInputStream in = new DataInputStream(new FileInputStream(f));

//        System.out.println(in.readByte());
//        System.out.println(in.readChar());
        System.out.println(in.readUTF());

        in.close();
    }

    private static void write(File f) throws Exception
    {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(f));

//        out.writeByte(65);
//        out.writeChar('哈');
        out.writeUTF("今天怎么样..");

        out.close();
    }
}
