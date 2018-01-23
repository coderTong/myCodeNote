package LightweightProcess;

/**
 * Created by codew on 2018/1/23.
 */

// 共享资源
public class NVShareResource {

    private String name;
    private String gender;
    private boolean isEmpty = true; // 表示共享资源对象是否为空的状态

   synchronized public void push(String name, String gender){

        try {

            while (!isEmpty){// 当前isEmpty为false的时候, 不空等着消费者来获取

                this.wait();// 使用同步锁对象来调用, 表示当前线程释放同步锁,进入等待池, 只能被其他线程唤醒
            }

            // -----开始生产------
            this.name = name;
            Thread.sleep(10);
            this.gender = gender;
            // -----生产结束-------
            isEmpty = false; // 设置共享资源中数据不为空
            // 生产结束唤醒消费者
            this.notify();
        }catch (InterruptedException e){

            e.printStackTrace();
        }



    }

    synchronized public void popup()
    {
        try {

            while (isEmpty){ // 当前isEmpty为true的时候, 为空, 等待生产者来生产
                // 使用同步锁对象来调用, 表示当前线程释放同步锁, 进入等待池, 只能被其他线程所唤醒
                this.wait();
            }
            // -----消费开始------
            Thread.sleep(10);
            System.out.println(this.name + "-" + this.gender);
            // -----消费结束------
            isEmpty = true;
            // 消费完了唤醒一个生产者
            this.notify();
        }catch (InterruptedException e){

            e.printStackTrace();
        }


    }
}
