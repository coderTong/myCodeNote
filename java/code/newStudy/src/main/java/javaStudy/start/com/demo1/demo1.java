package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/20.
 */



class Animal
{
    private String name;
    private int age;

    public static final int X_SIZE = 100;
    public static final int Y_SIZE = 100;

    Animal()
    {
        System.out.println("Animal 构造器");
    }


    void sayLove()
    {
        System.out.println("Animal sayLove");
    }

}


class NV_GlobalSingleton
{
    // 1.必须在类中,自己先创建一个对象
    private static final NV_GlobalSingleton instance = new NV_GlobalSingleton();

    // 2.私有化自身的构造器
    private NV_GlobalSingleton(){}

    // 3.提供获取方法
    public static NV_GlobalSingleton getInstance()
    {
        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

class Fish extends Animal
{
    private String color; // 颜色

    Fish()
    {

        System.out.println("Fish 构造器");
    }

    void sayLove()
    {
        System.out.println("Fish sayLove");
    }
}

class dog extends Animal
{

}


public class demo1 {

    public static void main(String[] args)
    {
        NV_GlobalSingleton globalSingleton = NV_GlobalSingleton.getInstance();

        String userId = globalSingleton.getUserID();

        System.out.println(userId);



        String nuStr = "503";
        int num = Integer.parseInt(nuStr);

        num -=100;

        System.out.println(num);


    }

    static void test1()
    {
        Animal f = new Fish();

        f.sayLove();


        if (f instanceof dog){

            System.out.println("YES");
        }else {

            System.out.println("NO");
        }

    }

}



