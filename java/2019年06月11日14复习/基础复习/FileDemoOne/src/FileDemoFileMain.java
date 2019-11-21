import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileDemoFileMain {

    public static void main(String[] args) {

        File dir = new File("/Users/codew/Desktop/Net/java");
        printDir(dir);
    }


    public static void printDir(File file)
    {
        File[] files = file.listFiles();

        for (File fi: files) {


            if (fi.isFile()){

                if (fi.getName().endsWith("java")){

                    System.out.println("文件名: " + fi.getAbsolutePath());
                }
            }else {

                printDir(fi);
            }
        }
    }


    public static void fileTest(){

        File file1 = new File("/Users/codew/Desktop/Net/java/");


        String parent = "/Users/codew/Desktop/Net/java/";
        String child = "test2.txt";

        File file2 = new File(parent, child);


        System.out.println( "文件绝对路径:" + file2.getAbsolutePath());
        System.out.println( "文件构造路径:" + file2.getPath());
        System.out.println( "文件名称:" + file2.getName());
        System.out.println( "文件长度:" + file2.length() + "字节");
        System.out.println( "目录? :" + file2.isDirectory() );

        System.out.println("真的存在? :" + file2.exists());




        try {

            /***
             *  2019年06月18日19:48:26
             *  smm过几天离开公司......山西运城
             * 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
             * */
            file2.createNewFile();

        } catch (IOException e) {


            e.printStackTrace();
        }


        System.out.println("删除结果: " + file2.delete());
        System.out.println("创建文件夹的结果: " + file1.mkdirs());


        System.out.println("....");

        /**
         * 一个是String数组
         * 2019年06月19日10:09:40
         *
         * */
        String[] arr = file1.list();

        /**
         * 一个是File 数组
         * 2019年06月19日10:09:42
         *
         * */
        File[] arr2 = file1.listFiles();
//        for (int i = 0; i < arr.length; i++) {
//
//            Object object = arr[i];
//            System.out.println(object);
//            System.out.println(object.getClass());
//        }


        List<File> filesList = new ArrayList<>();
        Collections.addAll(filesList, arr2);

        for (File file: filesList) {

            System.out.println(file.getAbsolutePath());
        }


        List<String> list2 = new ArrayList<String>();
        /**
         * 居然是Collections的方法,好找....
         * 2019年06月19日09:41:18
         * 昨天稀里糊涂, 还发了条那啥,啊哈哈哈, 我去,但是这事一本万利,万分之一损失不足挂齿
         * */
        Collections.addAll(list2, arr);

        for (String str: list2) {

//            System.out.println(str);
        }


//        System.out.println(arr.toString());
//
//
//        ArrayList list = (ArrayList) Arrays.asList(arr);
//
//        for (Object str: list) {
//
//            System.out.println(str);
//        }

    }
}














