package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */


class Apple3 implements Runnable
{
    private int num = 500; // 苹果总数


    @Override
    public void run() {

        for (int i = 0; i < 500; i++) {

            eat();
        }
    }

    synchronized private void eat()
    {
        if (num > 0)
        {
            System.out.println(Thread.currentThread().getName() + "吃了编号: " + num + "的苹果");
            num--;
        }
    }
}
public class SynchronizeMethodDemo {

    public static void main(String[] args)
    {
        Apple3 a = new Apple3();


        new Thread(a, "小A").start();
        new Thread(a, "小B").start();
        new Thread(a, "小C").start();
    }
}
