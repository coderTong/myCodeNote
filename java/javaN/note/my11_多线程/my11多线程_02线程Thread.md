创建多线程程序的第一中方式 创建Thread类的子类
java. Lang. Thread类:是描述线程类,我们想要实现多线程程序,就必須継承Thread类
突現歩驟:
1.創建一个Thread类的子类
2.在Thread类的子类中重写Thread类中的run方法,没置多程任务(开启线程要做什么?)

3.創建Thread类的子类对象
4.凋用Thread类中的方法start方法,开启新的线程,抛行run方法

- void start() 使该线程开始执行; Java 虚抓机調用该线程的run方法。
- 結果是两个线程并发地运行;当前线程〈main线程〉和另一个线程く 创建的新线程,抛行其run方法〉。
- 多次启动一个线程是非法的。特別是当线程已经結束抛行后,不能再重新后动



java程序抢占式调度， 那个线程的优先级高， 哪个线程先执行， 同一个优先级， 随机执行。





```java

package com.codertomwu.MyThreadTest;

public class MyThread  extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {


            try {
                this.sleep(1000);// 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run:" + i);
        }
        
    }
}



package com.codertomwu.MyThreadTest;

public class MyThreadMain {

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        thread.setName("tom_TEST");
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 20; i++) {
            System.out.println("Main:" + i);
        }
    }
}


```





