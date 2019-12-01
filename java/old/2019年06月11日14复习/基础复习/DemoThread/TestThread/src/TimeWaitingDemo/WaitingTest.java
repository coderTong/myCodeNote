package TimeWaitingDemo;

public class WaitingTest {

    public static Object obj = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {


                while (true){


                    synchronized (obj){


                        try {

                            System.out.println( Thread.currentThread().getName() + "====  获取到锁对象, 调用wait方法, 进入Waiting状态,,  释放锁对象");
                            obj.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                        System.out.println(Thread.currentThread().getName() + "=====  从Waiting状态醒来,   获取到锁对象, 继续执行了");

                    }

                }

            }
        }, "等待线程").start();



        new Thread(new Runnable() {
            @Override
            public void run() {


                try {

                    System.out.println(Thread.currentThread().getName() + "--------- 等待3秒");
                    Thread.sleep(3000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }


                synchronized (obj){

                    System.out.println(Thread.currentThread().getName() + "-----  获取到锁对象, 调用notify方法, 释放锁对象");
                    obj.notify();
                }


            }
        }, "唤醒线程").start();

    }
}
