package IODemo.Writer_Reader;

import java.util.Arrays;

/**
 * Created by codew on 2018/1/25.
 */

public class EncodingDemo {

    public static void main(String[] args) throws Exception {

        String msg = "着色器";
        // 编码操作 String--->byte[]

        byte[] data = msg.getBytes("UTF-8");
        System.out.println(Arrays.toString(data));

        // 解码操作: byte[] --> String
        String ret = new String(data, "ISO-8859-1");
        System.out.println(ret);

        // 中文乱码
        // 解决方案

        data = ret.getBytes("ISO-8859-1");
        System.out.println(Arrays.toString(data));
        ret = new String(data, "UTF-8");
        System.out.println(ret);
    }
}
