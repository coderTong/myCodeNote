package IODemo.MemoryArray;

import java.io.FileInputStream;
import java.io.SequenceInputStream;

/**
 * Created by codew on 2018/1/27.
 */
public class SequenceInputStreamDemo {


    public static void main(String[] args) throws Exception
    {
        SequenceInputStream in = new SequenceInputStream(new FileInputStream("file/stream.txt"),
                new FileInputStream("file/stream_copy.txt"));

        byte[] buffer = new byte[1024];
        int len = -1;

        while ( (len = in.read(buffer)) != -1 ){
            System.out.println(new String(buffer,0,len));
        }
    }
}
