package StreamIOTest;

import java.io.*;

public class ImageCopyDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/codew/Desktop/Net/java/backGImage.jpg");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileOutputStream fileOutputStream = new FileOutputStream("meinv.jpg", true);

        int len;

        byte[] read = new byte[100];

        while (  (len = fileInputStream.read(read)) != -1  ){


//            fileOutputStream.write(read);
            fileOutputStream.write(read, 0, len);

        }


        // 流的关闭原则:先开后关，后开先关。
        fileOutputStream.close();
        fileInputStream.close();


    }

}
