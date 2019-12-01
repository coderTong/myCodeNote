# 属性集Properties



# Buffered系列, 提升效率

缓冲流, 转换流, 序列化流

# 缓冲流

- **字节缓冲**:`BufferedInputStream`, `BufferedOutputStream`
- **字符缓冲流 **:`BufferedReader`,`BufferedWriter`


# 转换流

- InputStreamReader
- OutputStreamWriter

```java

package com.codertomwu.my1110IOBuffered.ReverseStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by codew on 11/10/18. */   /*
 java.io.OutputStreamWriter extends Writer OutputStreamWriter: 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。(编码:把能看懂的变成看不懂)   继续自父类的共性成员方法: - void write(int c) 写入单个字符。 - void write(char[] cbuf)写入字符数组。 - abstract  void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。 - void write(String str)写入字符串。 - void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。 - void flush()刷新该流的缓冲。 - void close() 关闭此流，但要先刷新它。 构造方法: OutputStreamWriter(OutputStream out)创建使用默认字符编码的 OutputStreamWriter。 OutputStreamWriter(OutputStream out, String charsetName) 创建使用指定字符集的 OutputStreamWriter。 参数: OutputStream out:字节输出流,可以用来写转换之后的字节到文件中 String charsetName:指定的编码表名称,不区分大小写,可以是utf-8/UTF-8,gbk/GBK,...不指定默认使用UTF-8 使用步骤: 1.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称 2.使用OutputStreamWriter对象中的方法write,把字符转换为字节存储缓冲区中(编码) 3.使用OutputStreamWriter对象中的方法flush,把内存缓冲区中的字节刷新到文件中(使用字节流写字节的过程) 4.释放资源 */ public class Demo02OutputStreamWriter {

    public static void main(String[] args) throws IOException {

        show1();
    }

    // 写 GBK    public static void show1() throws IOException{

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("BufferedIO/gbk.txt"), "GBK");
        outputStreamWriter.write("兄嘚...");
        outputStreamWriter.flush();
        outputStreamWriter.close();

    }

    public static void show2() throws IOException{

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("BufferedIO/utf8.txt"));
        outputStreamWriter.write("兄嘚...");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

}

```



```java

package com.codertomwu.my1110IOBuffered.ReverseStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by codew on 11/10/18. */   /*
 java.io.InputStreamReader extends Reader InputStreamReader:是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。(解码:把看不懂的变成能看懂的)   继承自父类的共性成员方法: int read() 读取单个字符并返回。 int read(char[] cbuf)一次读取多个字符,将字符读入数组。 void close() 关闭该流并释放与之关联的所有资源。 构造方法: InputStreamReader(InputStream in) 创建一个使用默认字符集的 InputStreamReader。 InputStreamReader(InputStream in, String charsetName) 创建使用指定字符集的 InputStreamReader。 参数: InputStream in:字节输入流,用来读取文件中保存的字节 String charsetName:指定的编码表名称,不区分大小写,可以是utf-8/UTF-8,gbk/GBK,...不指定默认使用UTF-8 使用步骤: 1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称 2.使用InputStreamReader对象中的方法read读取文件 3.释放资源 注意事项: 构造方法中指定的编码表名称要和文件的编码相同,否则会发生乱码 */ public class Demo03InputStreamWriter {

    public static void main(String[] args) throws IOException {

//        read_gbk();
  read_utf();
    }

    public static void read_gbk()throws IOException {

        InputStreamReader  inputStreamReader = new InputStreamReader(new FileInputStream("BufferedIO/gbk.txt"), "GBK");
        int len = 0;

        while ((len = inputStreamReader.read()) != -1){

            System.out.println((char)len);
        }
        inputStreamReader.close();

    }
    public static void read_utf() throws IOException {

        InputStreamReader  inputStreamReader = new InputStreamReader(new FileInputStream("BufferedIO/2.txt"));
        int len = 0;

        while ((len = inputStreamReader.read()) != -1){

            System.out.println((char)len);
        }
        inputStreamReader.close();

    }

}

```

# 序列化


