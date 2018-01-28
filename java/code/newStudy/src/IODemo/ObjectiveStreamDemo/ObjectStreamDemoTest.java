package IODemo.ObjectiveStreamDemo;

import java.io.*;

/**
 * Created by codew on 2018/1/27.
 */
public class ObjectStreamDemoTest {

    public static void main(String[] args) throws Exception{

        File f = new File("file/obj.txt");

//        writeObject(f);
        readObject(f);
    }

    // 序列化
    private static void writeObject(File f) throws Exception
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject( new ObjectStreamUser("tom", "1234", 17));
        out.close();
    }

    // 反序列化
    private static void readObject(File f) throws Exception
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        ObjectStreamUser user = (ObjectStreamUser)in.readObject();

        System.out.println(user);
        in.close();
    }
}
