package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

class Apple2 implements Runnable

{
    private int num = 1000; // 苹果总数


    synchronized public void doWork(){

       // TODO
    }

    @Override
    public void run() {


        for (int i = 0; i < num; i++) {

            synchronized (this){
                if (num > 0)
                {


//                    try {
//
//                        Thread.sleep(10);
//
//                    }catch (InterruptedException e){
//
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() + "吃了编号: " + num + "的苹果");
                    num--;
                }

            }


        }
    }
}


public class SynchronizedBlockDemo {

    public static void main(String[] args)
    {
        Apple2 a = new Apple2();

        new Thread(a, "小A").start();
        new Thread(a, "小B").start();
        new Thread(a, "小C").start();
    }
}
