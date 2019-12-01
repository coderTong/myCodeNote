1. File类操作
2. 输入和输出(IO)
3. 文件流
4. 字节流
5. 文件字符流
6. 字符编码
7. 包装流和缓冲流概述
8. 转换流和内存流
9. 合并流
10. 对象流(序列化和反序列化)
11. 打印流
12. 标注IO概述和操作
13. 扫描器类(Scanner)
14. Properties类加载文件
15. 数据流
16. 随机访问文件(RandomAccessFile)
17. 管道流
18. NIO



# File类操作

## File类介绍
Java的集合框架: 类和接口存在于java.util包中.
Java的IO:   类和接口存在于java.io包中.

讲IO操作之前,必须要先讲File类(文件/目录).

***File类介绍和路径分隔符:***

- File类是IO包中唯一表示磁盘文件和磁盘目录的对象的路径.
- 该类包含了创建,删除文件,重命名文件,判断文件读写权限以及文件是否存在,查询等功能方法.
- 只能设置和获取文件本身的信息,不能设置和获取文件的内容.

Java做开发: 一次编写,到处运行.
Unix: 严格区分大小写.
WIndows: 默认情况下是不区分大小写的.

路径分隔符,属性分隔符:

Unix: 使用”/”,来分割目录路径. 使用:来分割属性.

Windows: 使用”\”,来分割目录路径.但是在Java中一个”\”表示转义,在Windows平台的Java代码中表示一个路径,就得使用两个\\. 但是Windows支持/. 使用;来分割属性.

-----------------------------------------------------------------------------------------

因为我们不知道以后运行的系统平台是什么,就不知道该如何编写分隔符的问题,因此在File类中提供了两类常量,分别来表示路径分隔符和属性分隔符.

```

package FileTestDemo;

import java.io.File;

/**
 * Created by codew on 2018/1/24.
 */
public class FileDemo2 {

    public static void main(String[] args)
    {

File f1 = new File("/Users/codew/Desktop/Test/AAC/abc.m");
File f2 = new File("/Users/codew/Desktop/Test/AAC", "abc.m");

File dir = new File("/Users/codew/Desktop/Test/AAC");
File f3 = new File(dir, "abc.m");
System.out.println(f1);

        test2();
    }



    /**

     操作File路径和名称:
     File getAbsoluteFile() :获取绝对路径
     String getAbsolutePath():获取绝对路径
     String getPath() :获取文件路径
     String getName() :获取文件名称
     File getParentFile():获取上级目录文件
     String getParent() :获取上级目录路径

     */
    private static void test1()
    {
        File f1 = new File("/Users/codew/Desktop/Test/AAC/abc.m");

        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getAbsoluteFile());

        System.out.println(f1.getName());
        System.out.println(f1.getPath());

        System.out.println(f1.getParentFile());
        System.out.println(f1.getParent());

    }

    /**

     检测File状态的方法:
     boolean canExecute() :判断是否是可执行文件
     boolean canRead() :判断该文件是否可读
     boolean canWrite():判断该文件是否可写
     boolean isHidden():判断该文件是否是隐藏文件

     long lastModified():判断该文件的最后修改时间
     long length():获取该文件的长度大小(单位字节)

     */
    private static void test2()
    {
        File f1 = new File("/Users/codew/Desktop/Test/AAC/abc.java");

        System.out.println(f1.canExecute());
        System.out.println(f1.canRead());

        System.out.println(f1.canWrite());
        System.out.println(f1.isHidden());

        System.out.println( new java.util.Date(f1.lastModified()) );
        System.out.println(f1.length());
    }
}

```


# File文件操作和目录操作

```

File类中方法-文件操作:

boolean isFile() :是否是文件

boolean createNewFile() :创建新的文件

static File createTempFile(String prefix, String suffix) :创建临时文件

boolean delete() :删除文件

void deleteOnExit() :在JVM停止时删除文件

boolean exists():判断文件是否存在

boolean renameTo(File dest) :重新修改名称

---------------------------------------------------------------------

File类中方法-目录操作

boolean isDirectory() :判断是否是目录

boolean mkdir() :创建当前目录

boolean mkdirs() :创建当前目录和上级目录

String[] list() :列出所有的文件名

File[] listFiles() :列出所有文件对象

static File[] listRoots() :列出系统盘符

```
```

private static void test3()
    {
        File f1 = new File("/Users/codew/Desktop/Test/AAC/abc.java");
        System.out.println(f1.isFile());



        File f2 = new File("/Users/codew/Desktop/Test/AAC/abc.m");

        if (!f2.exists()){

            try {

                f2.createNewFile();

            }catch (IOException e){

                e.printStackTrace();
            }


        }else {
            // 改个名看看, 没有写全路径,在MAC上就是工程的根目录
//            f2.renameTo(new File("/Users/codew/Desktop/Test/AAC/ccc12345"));

            // 删除试试
//            f2.delete();


        }

        //        System.out.println(f1.canRead());
        //        System.out.println(f1.canRead());
        //        System.out.println(f1.canRead());
        //        System.out.println(f1.canRead());
    }

    // 创建临时文件
    private static void test4() throws IOException
    {
        /**
         File createTempFile(String prefix, String suffix, File directory)
         */
//        File.createTempFile("xxx153001","", new File(""));
        File.createTempFile("xxx153001",".xxxtmp", new File("/Users/codew/Desktop/Test/AAC/"));
    }




/**

     目录操作


     boolean isDirectory() :判断是否是目录

     boolean mkdir() :创建当前目录

     boolean mkdirs() :创建当前目录和上级目录

     String[] list() :列出所有的文件名

     File[] listFiles() :列出所有文件对象

     static File[] listRoots() :列出系统盘符


     */

    private static void test5() throws IOException
    {
        File f = new File("/Users/codew/Desktop/Test/AAC/");

//        System.out.isDirectoryprintln(f.isDirectory());
//        System.out.println(f.mkdir());
//        System.out.println(f.mkdirs());


//        String[] list = f.list();
////        System.out.println(list.toString());
//        for (String s: list) {
//
//            System.out.println(s);
//        }


//        File[] list2 = f.listFiles();
//
//        for (File fItem: list2) {
//
//            System.out.println(fItem);
//        }

        // 访问系统的根
        File[] list3 = f.listRoots();

        for (File fItem: list3) {

            System.out.println(fItem);
        }



    }
```


## 文件过滤


```

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


```

