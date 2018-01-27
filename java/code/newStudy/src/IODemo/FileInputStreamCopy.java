package IODemo;

import java.io.*;

/**
 * Created by codew on 2018/1/25.
 */
public class FileInputStreamCopy {

    public static void main(String[] args) throws Exception
    {

        // 1. 找到源目录所有的java文件
        File srcDir = new  File("/Users/codew/Desktop/Test/AAC");
        File destDir = new  File("/Users/codew/Desktop/Test/AAC/java");

        if (!destDir.exists()){

            System.out.println("没有这个文件夹");
            destDir.mkdirs();
        }

        File[] fs = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return new File(dir, name).isFile() && name.endsWith(".java");
            }
        });

        // 2. 迭代出出每一个文件对象, 并拷贝

        for (File srcFile: fs) {

            // 创建流对象
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(new File(destDir, srcFile.getName()));
            // 读写操作
            byte[] buffer = new byte[1024];
            int len = -1;
            len = in.read(buffer);
            while (len != -1){

                out.write(buffer, 0, len);
                len = in.read(buffer);
            }

            // 关闭资源
            in.close();
            out.close();
        }

    }

}
