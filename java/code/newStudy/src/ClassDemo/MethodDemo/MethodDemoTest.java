package ClassDemo.MethodDemo;

import java.lang.reflect.Method;

/**
 * Created by codew on 2018/1/29.
 */
class User{

    public User(){

    }

    public void doWorkObj()
    {

    }

    public static void doWork()
    {

    }

    public static void doWork(String name)
    {

    }

    private String sayHello(String msg, int count)
    {
        return "说:" + msg + " " + "count:" + count;
    }
}


public class MethodDemoTest {

    public static void main(String[] args) throws Exception{

        getOne();
    }

    // 获取User类中指定的一个方法
    private static void getOne() throws Exception
    {
        Class clz = User.class;

        // 获取没有参数方法
        Method m = clz.getMethod("doWork");
        System.out.println(m);

        // 获取有参数
        m = clz.getMethod("doWork", String.class);
        System.out.println(m);

        // 获取两个参数
        m = clz.getDeclaredMethod("sayHello", String.class, int.class);
        System.out.println(m);
    }
    // 获取User类中所有的方法
    private static void getAll() throws Exception
    {
        Class clz = User.class;

        // 获取本类加父类的所有方法
        Method[] ms = clz.getMethods();
        System.out.println(ms.length);
        for (Method m: ms) {

            System.out.println(m);
        }

        System.out.println("===============================");
        // 只获取本类的方法
        ms = clz.getDeclaredMethods();
        System.out.println(ms.length);
        for (Method m: ms) {

            System.out.println(m);
        }
    }

}
