package thread_Method;

/**
 * Created by codew on 2018/1/24.
 */

class PriorityThread extends Thread
{

    public PriorityThread(String name)
    {
        super(name);
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 100; i++) {

            System.out.println(super.getName() + "-" + i);
        }
    }
}



public class ThreadPriorityDemo {

    public static void main(String[] args){

        PriorityThread max = new PriorityThread("高优先级");
        max.setPriority(Thread.MAX_PRIORITY); // 设置优先级为10

        PriorityThread min = new PriorityThread("低");
        min.setPriority(Thread.MIN_PRIORITY); // 设置优先级为1

        PriorityThread min2 = new PriorityThread("低2");
        min2.setPriority(Thread.MIN_PRIORITY); // 设置优先级为1

        PriorityThread min3 = new PriorityThread("低3");
        min3.setPriority(Thread.MIN_PRIORITY); // 设置优先级为1

        PriorityThread min4 = new PriorityThread("低4");
        min4.setPriority(Thread.MIN_PRIORITY); // 设置优先级为1

        PriorityThread min5 = new PriorityThread("低5");
        min5.setPriority(Thread.MIN_PRIORITY); // 设置优先级为1

        max.start();
        min.start();
        min2.start();
        min3.start();
        min4.start();
        min5.start();
//        min5.start();


        /**
         *

         // 线程的优先级可以先启动后设置
         // 获取优先级
         Thread.currentThread().getPriority();
         // 设置优先级
         Thread.currentThread().setPriority(100);

         **/

    }

}
