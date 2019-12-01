package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

class Person extends Thread{

    private int num = 50; // 苹果总数

    public Person(String name)
    {
        super(name);
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 50; i++) {

            if (num > 0)
            {
                System.out.println(super.getName() + "吃了编号: " + num-- + "的苹果");
            }

        }
    }
}



public class ThreadDemo2T {

    public static void main(String[] args)
    {
        new Person("小A").start();
        new Person("小B").start();
        new Person("小C").start();
    }
}
