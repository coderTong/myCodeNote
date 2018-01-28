package IODemo.RandomAccessFileDemo;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by codew on 2018/1/28.
 */

// 读写文件的任意位置
public class RandomAccessFileDemo {

    public static void main(String[] args) throws Exception{

        File f = new File("file/raf.txt");

//        write(f);
        read(f);
    }

    private static void read(File f) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile(f, "r");

        System.out.println("文件指针位置:" + raf.getFilePointer());
        byte b = raf.readByte();
        System.out.println(b);


        System.out.println("文件指针位置:" + raf.getFilePointer());
        String str = raf.readUTF();
        System.out.println(str);

        System.out.println("文件指针位置:" + raf.getFilePointer());
        // 设置文件指针为0个字节
        raf.seek(0);
        System.out.println("文件指针位置:" + raf.getFilePointer());

        // 设置文件指针跳过12个字节
        raf.skipBytes(12);
        System.out.println("文件指针位置:" + raf.getFilePointer());

        int i = raf.readInt();
        System.out.println(i);

        System.out.println("文件指针位置:" + raf.getFilePointer());
        raf.close();
    }

    private static void write(File f) throws Exception
    {
        RandomAccessFile raf = new RandomAccessFile(f, "rw");

        raf.writeByte(65);
        raf.writeUTF("天和荣"); // 使用的是修改之后的UTF-8, 多两个字节
        raf.writeInt(17);

        raf.close();
    }
}
