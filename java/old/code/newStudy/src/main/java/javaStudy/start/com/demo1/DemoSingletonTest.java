package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

enum NV_GlobalSingleton3
{
    INSTANCE;

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

// 单例模式-饿汉式
class NV_GlobalSingleton4
{
    private NV_GlobalSingleton4(){}

    private static NV_GlobalSingleton4 instance = new NV_GlobalSingleton4();
    public static NV_GlobalSingleton4 getInstance(){

        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

// 单例模式-懒汉式
class NV_GlobalSingleton5
{
    private NV_GlobalSingleton5(){}

    private static NV_GlobalSingleton5 instance = null;

    synchronized public static NV_GlobalSingleton5 getInstance(){

        if (instance == null){

            instance = new NV_GlobalSingleton5();
        }
        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

// 单例模式-懒汉式-双重检查锁
class NV_GlobalSingleton6
{
    private NV_GlobalSingleton6(){}

    private static volatile NV_GlobalSingleton6 instance = null;

    public static NV_GlobalSingleton6 getInstance(){

        if (instance == null){

            synchronized (NV_GlobalSingleton6.class){

                if (instance == null)
                {
                    instance = new NV_GlobalSingleton6();
                }
            }


        }
        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

public class DemoSingletonTest {

    public static void main(String[] args){
        System.out.println("");
    }
}
