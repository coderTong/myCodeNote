package IODemo;

import java.util.Map.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by codew on 2018/1/25.
 */
public class SystemPropertiesDemo {

    public static void main(String[] args)
    {

        Properties pro = System.getProperties();

        Set<Entry<Object, Object>> entrySet = pro.entrySet();

        for (Entry<Object, Object>entry: entrySet) {

            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("-------------------------------");

        String val = System.getProperty("user.dir");
        System.out.println(val);

    }
}
