package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */


class Apple implements Runnable
{
    private int num = 50; // 苹果总数

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            if (num > 0)
            {
                try {

                    Thread.sleep(10);

                }catch (InterruptedException e){

                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "吃了编号: " + num-- + "的苹果");
            }

        }
    }
}


public class ThreadDemo3Runnable {

    public static void main(String[] args)
    {
        Apple a = new Apple();

        new Thread(a, "小A").start();
        new Thread(a, "小B").start();
        new Thread(a, "小C").start();

    }



}
