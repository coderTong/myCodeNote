package producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by codew on 2018/1/23.
 */

// 共享资源
public class NVShareResource {

    private String name;
    private String gender;
    private boolean isEmpty = true; // 表示共享资源对象是否为空的状态
    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void push(String name, String gender){

        // 进入方法立马获取锁
        lock.lock();

        try {

            while (!isEmpty)
            {
                // 不为空等待
                condition.await();

            }
            // -----开始生产------
            this.name = name;
            Thread.sleep(10);
            this.gender = gender;

            condition.signal();
            isEmpty = false;
        }catch (InterruptedException e){

            e.printStackTrace();

        }finally {

            lock.unlock(); // 释放锁
        }



    }

    public void popup()
    {

        lock.lock();
        try {
            while (isEmpty)
            {
                // 不为空等待
                condition.await();

            }

            Thread.sleep(10);
            System.out.println(this.name + "-" + this.gender);

            isEmpty = true;
            condition.signalAll();

        }catch (InterruptedException e){

            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}
