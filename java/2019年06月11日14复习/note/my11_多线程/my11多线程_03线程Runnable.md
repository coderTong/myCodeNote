# Runnable

实现Runnable接口， 也是非常常见的一种方式， 我们只需要重写run方法即可。

- 1.定义Runnable接口的实现类， 并重写该接口的run（）方法。 该run（）方法的方法体同样是该线程的线程执行体
- 2.创建Runnable实现类的实例， 并以此实例作为Thread的target来创建Thread对象， 该Thread对象才是真正的线程对象。
- 3.调用线程对象的start（）方法启动线程



# Runnable 实现1



```java

package com.codertomwu.MyThreadTest;

public class MyRunnableMain {

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}



package com.codertomwu.MyThreadTest;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {

            System.out.println("RunnablClass:"+i);
        }
    }
}


```







# 实现Runnable 的好处

1.避免单继承的局限性

2.增强程序的扩展性





# 第二种





```java

package com.codertomwu.MyThreadTest;

public class MyRunnableMain {

    public static void main(String[] args) {
        test2();
        test3();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }


    public static void test3(){

        new Thread(new Runnable(){

            @Override
            public void run() {

            }
        }).start();
    }
    public static void test2(){

        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("imp:" + i);
                }
            }
        }.start();

    }
    public static void test1(){

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}


```

