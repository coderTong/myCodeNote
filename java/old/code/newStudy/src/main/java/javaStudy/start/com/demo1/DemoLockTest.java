package javaStudy.start.com.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by codew on 2018/1/23.
 */

class Apple5 implements Runnable

{
    private int num = 666; // 苹果总数



    private final Lock lock = new ReentrantLock();

    synchronized public void doWork(){

        // TODO
    }

    @Override
    public void run() {

        for (int i = 0; i < 666; i++) {

            eat();

        }

    }


    private void eat(){

        // 进入方法立马加锁(进入厕所,立马关门)
        lock.lock();


        try {

            if (num > 0)
            {
                System.out.println(Thread.currentThread().getName() + "吃了编号: " + num + "的苹果");

                Thread.sleep(10);

                num--;
            }


        }catch (InterruptedException e){

            e.printStackTrace();

        }finally {

            // 释放锁
            lock.unlock();
        }


    }

}

public class DemoLockTest {

    public static void main(String[] args)
    {
        Apple5 a = new Apple5();

        new Thread(a, "小A").start();
        new Thread(a, "小B").start();
        new Thread(a, "小C").start();
    }

}
