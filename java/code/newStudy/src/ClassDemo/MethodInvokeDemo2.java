package ClassDemo;


import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by codew on 2018/1/29.
 */

class Emloyee
{

    // =============================================================类
    // 无返回 无参数
    public static void doWork()
    {
        System.out.println("doWork, 无参数");
    }

    // 无返回 有参数
    public static void doWork(String name)
    {
        System.out.println("doWork, name:" + name);
    }

    // 又返回 多参数
    public static int doWork(String name, int age)
    {
        System.out.println("doWork, name:" + name + " " + "age:" + age);

        return age;
    }

    // 有返回 有参数 私有方法
    private static int doWorkP(String name, int age)
    {
        System.out.println("doWork私有方法, name:" + name + " " + "age:" + age);

        return age;
    }
    // =============================================================对象
    public void objMethod()
    {
        System.out.println("对象方法:objMethod");
    }

    // 对象方法多参数
    public void objMethodMoreArgs(String name, int age, float cm)
    {
//        System.out.println("对象方法多参数: name:" + name + " " + "age:" + age + " " + "cm:" +cm);

        System.out.printf("对象方法多参数: name %s, name: %d, cm:%f", name, age, cm);
    }


    public void objMethod(String name)
    {
        System.out.println("对象方法: name:" + name);
    }

    // =============================================================类, 可变参数
    public static void doWorkMutable(int... arr)
    {
        System.out.println("doWorkMutable," + Arrays.toString(arr));
    }

    public static void doWorkMutable(String... arr)
    {
        System.out.println("doWorkMutable," + Arrays.toString(arr));
    }
}


// 使用反射调用数组参数()
public class MethodInvokeDemo2 {

    public static void main(String[] args) throws Exception{

        Class clz = Emloyee.class;
        Method m = clz.getMethod("doWork");
// =============================================================类
//        // 类方法=====> 调用无参数
//
//        m.invoke(null);
//        m.invoke(clz.newInstance());// clz.newInstance() // 前提是类提供了一个公共无参数的构造器
//
//
//        //类方法=====> 调用有参数
//        m = clz.getMethod("doWork", String.class);
//        m.invoke(null, "lucy");
//
//        //类方法=====> 有参数, 有返回值
//        m = clz.getMethod("doWork", String.class, int.class);
//       Object ob = m.invoke(null, "lucy", 22);
//       System.out.println(ob);
//
//
//       //类方法=====> 私有方法
//        m = clz.getDeclaredMethod("doWorkP", String.class, int.class);
//        m.setAccessible(true);
//        ob = m.invoke(null, "lili", 19);
//        System.out.println(ob);
// =============================================================对象

//        // 对象方法====> 类方法无所谓, 如果是调用对象方法,必须要传对象进去
//        m = clz.getMethod("objMethod");
//        m.invoke(clz.newInstance());
//
//        // 对象方法====> 类方法无所谓, 如果是调用对象方法,必须要传对象进去
//        m = clz.getMethod("objMethod", String.class);
//        m.invoke(clz.newInstance(), "cicy");
//
//
//        // 对象方法====> 类方法无所谓, 如果是调用对象方法,必须要传对象进去
//        // objMethodMoreArgs
//        // 去找无参数的方法,实际山没有调用是传了很多参数, 并没有报错,实际上没执行
//        m = clz.getMethod("objMethodMoreArgs");
////        m.invoke(clz.newInstance(), "cicy", 17, 120.9f);
//        m.invoke(clz.newInstance());
////
////        m = clz.getMethod("objMethodMoreArgs", String.class, int.class, float.class);
////        // 对象方法参数很多, 你传的实参数不够也会报错
//////        m.invoke(clz.newInstance(), "cicy");
////        m.invoke(clz.newInstance(), "cicy", 17, 120.9f);


        // =============================================================类, 可变参数
        m = clz.getMethod("doWorkMutable", int[].class);
        m.invoke(null, new int[]{1,2,3,4,6});

        m = clz.getMethod("doWorkMutable", String[].class);

        m.invoke(null, new Object[]{ new String[]{"s","s0","s"} });
//        m.invoke(null, new String[]{"1","2","2"});
//
//        m.invoke(null, new Object[])new String[]{"1","2","2"}
    }

}
