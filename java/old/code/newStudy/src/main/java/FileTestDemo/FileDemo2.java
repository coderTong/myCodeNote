package FileTestDemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by codew on 2018/1/24.
 */
public class FileDemo2 {

    public static void main(String[] args) throws IOException
    {

        test5();
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


    /**
     *File类中方法-文件操作:

     boolean isFile() :是否是文件

     boolean createNewFile() :创建新的文件

     static File createTempFile(String prefix, String suffix) :创建临时文件

     boolean delete() :删除文件

     void deleteOnExit() :在JVM停止时删除文件

     boolean exists():判断文件是否存在

     boolean renameTo(File dest) :重新修改名称

     */
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

        // 加不加/都一样
//        File.createTempFile("xxx153001",".xxxtmp", new File("/Users/codew/Desktop/Test/AAC/"));
        File.createTempFile("99xxx153001",".xxxtmp", new File("/Users/codew/Desktop/Test/AAC"));
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


}
