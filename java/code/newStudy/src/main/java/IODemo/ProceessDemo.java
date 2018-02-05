package IODemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by codew on 2018/1/25.
 */


public class ProceessDemo {

    public static void main(String[] args) throws Exception
    {
        String str =  "System.out.println(\"一段文字\");";

//        System.out.println(str);
        eval(str);
    }

    // 执行str参数, 并在控制台打印
    private static void eval(String str) throws Exception{

        // 1. 使用StringBuilder拼接一个完整的HelloWorld 程序

        String nvClassName = "NVHello";
        String nvJava = ".java";

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("public class NVHello{");

        sBuilder.append("public static void main(String[] args){");

        sBuilder.append(str);

        sBuilder.append("}");

        sBuilder.append("}");

        // 2. 保存到一个java文件中去
        OutputStream out = new FileOutputStream(nvClassName+nvJava);
        out.write(sBuilder.toString().getBytes());
        out.close();

        // 3. 调用javaC进程来编译NVHello.java
        Process javacProcess = Runtime.getRuntime().exec("javac"+ " " + nvClassName+nvJava);

        // 4. 读取javac进程中的错误流信息
        InputStream error = javacProcess.getErrorStream();
        // 读取流中的数据
        byte[] buffer = new byte[1024];
        int len = -1;
        while ( (len = error.read(buffer)) != -1){

            String msg = new String(buffer, 0, len);
            System.out.println(msg);
        }

        error.close();

        // 5. 调用java进程来运行NVHello.java
        Process javaProcess = Runtime.getRuntime().exec("java" + " " + nvClassName);

        // 6. 读取java进程中的流信息
        InputStream info = javaProcess.getInputStream();
        while ( (len = info.read(buffer)) != -1 ){

            String msg = new String(buffer, 0, len);
            System.out.println(msg);
        }

        info.close();

        // 7. 删除java和class文件
        new File(nvClassName+nvJava).delete();
        new File(nvClassName+".class").delete();
    }
}

