#  进程与线程的区别:
进程:有独立的内存空间，进程中的数据存放空间(堆空间和栈空间) 是独立的，至少有一个线程。
线程: 堆空间是共享的，栈空间是独立的，线程消耗的资源也比进程小，相互之间可以影响的，又称为
轻型进程或进程元。
因为一个进程中的多个线程是并发运行的，那么从微观角度上考虑也是有先后顺序的，那么哪个线程执
行完全取决于CPU`调度器`，程序员是控制不了的。
我们可以把多线程并发性看作是多个线程在瞬间抢CPU资源，谁抢到资源谁就运行，这也造就了多线程的
随机性。
Java程序的进程里至少包含主线程和垃圾回收线程(后台线程)。

# java进程简单操作
mac上没用
```

public class demo8Process {

    public static void main(String[] args) throws Exception
    {

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepd");

        // 使用
  ProcessBuilder pb = new ProcessBuilder("notepd");
        pb.start();
    }
}


```


# 创建和启动线程

传统有两种方式

- 1.使用继承Thread
- 2.使用实现接口Runnable
   
线程类(java.lang.Thread), Thread类和Thread的子类

### 方式一, 继承Thread类


- 1,定义一个类A继承于java.lang.Thread
- 2,在A类中覆盖Thread类中的run方法
- 3, 在run方法中编写要执行的操作
- 4, 在main方法中,创建线程对象,启动线程
```

创建线程类  A类 a = new A类();
调用start a.start();// 启动一个线程

```


***实现继承***

```

package javaStudy.start.com.demo1;

import java.lang.Thread;

/**
 * Created by codew on 2018/1/22. */     class MusicThread extends Thread
{

    public static void playMusic()
    {
        for (int i = 0; i < 50; i++) {

            System.out.println("播放音乐:" + i);
        }
    }

    @Override
  public void run() {
        super.run();

        playMusic();
    }
}

public class DemoThread {

    public static void main(String[] args)
    {
        System.out.println("begin........");

        playGame();

        System.out.println("end........");
    }

    public static void playGame()
    {
        for (int i = 0; i < 50; i++) {

            if (i == 10)
            {
                // 创建线程并启动
  MusicThread t = new MusicThread();
                t.start();
            }
            System.out.println("打游戏:" + i);
        }
   }

}

```


# 方式2: 实现Runnable接口

方式2 : 实现Runnable接口;
步骤:
- 1):定义一个类A实现于java.lang.`Runnable`接口,`注意A类不是线程类.`
- 2):在A类中覆盖Runnable接口中的run方法.
- 3):我们在run方法中编写需要执行的操作--->n方法里的，线程执行体.
- 4):在main方法(线程)中，创建线程对象，并启动线程.
  - 创建线程类对象:   Thread t= new Thread(new A());
  - 调用线程对象的start方法: t.start()


```

package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22. */     class MusicRunnable implements Runnable
{
    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            System.out.println("播放音乐:" + i);
        }

    }
}

public class ImplementsRunnableDemo {

    public static void main(String[] args)
    {
        System.out.println("begin........");

        playGame();

        System.out.println("end........");
    }

    public static void playGame()
    {
        for (int i = 0; i < 50; i++) {

            if (i == 10)
            {
                // 创建线程并启动
  MusicRunnable runnable = new MusicRunnable();

                Thread t = new Thread(runnable);
                t.start();;

            }
            System.out.println("打游戏:" + i);
        }
    }

}


```


# 使用匿名内部类创建并启动线程

```

package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22. */ public class ImplementsRunnableDemo {

    public static void main(String[] args)
    {
        System.out.println("begin........");

        playGame();

        System.out.println("end........");
    }

    public static void playGame()
    {
        for (int i = 0; i < 50; i++) {

            if (i == 10)
            {
               new Thread(new Runnable() {
                   @Override
					public void run() {

                       for (int i = 0; i < 50; i++) {

                           System.out.println("播放音乐:" + i);
                       }

                   }
               }).start();

            }
            System.out.println("打游戏:" + i);
        }
    }

}

```



# 线程同步

线程不安全的问题分析:
`当多线程并发访问同一个资源对象的时候，可能出现线程不安全的问题`
但是，我们分析打印的结果，发现没有问题:
意识:看不到问题，我们经验不够，问题出现的不够明显.
接下来为了让问题更明显:
Thread.sleep(10);//当前线程睡10毫秒，当前线程休息着，让其他线程去抢资源.经常用来模拟网络延迟

```

package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22. */     class Apple implements Runnable
{
    private int num = 50; // 苹果总数    @Override
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


```

***结论:在线程的run方法上不能使用throws来声明抛出异常，只能在方法中使用try-catch来处理异常.***
原因是:`子类覆盖父类方法的原则，子类不能抛出新的异常.`
在Runnable接口中的run方法，都没有声明抛出异常.
`public abstract void run () ;`

## 同步代码块

***同步代码块***
语法:
```

synchronized( 同步锁)
{
	// 需要同步操作的代码
}

```
***同步锁***
`为了保证每个线程都能正常执行原子操作,Java引入了线程同步机制`
同步监听对象/同步锁/同步监听器/互斥锁:
对象的同步锁只是一个概念，可以想象为在对象上标记了一个锁
Java程序运行使用任何对象作为同步监听对象,但是一般的，我们把当前并发访问的共同资源作为同步监听对象.
注意:在任何时候,最多允许一个线程拥有同步锁.   谁拿到锁就进入代码块, 其他的线程只能在外等着


```

package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22. */   class Apple2 implements Runnable

{
    private int num = 1000; // 苹果总数    @Override
  public void run() {

        for (int i = 0; i < num; i++) {

            synchronized (this){
                if (num > 0)
                {

//                    try { // //                        Thread.sleep(10); // //                    }catch (InterruptedException e){ // //                        e.printStackTrace(); //                    }    System.out.println(Thread.currentThread().getName() + "吃了编号: " + num + "的苹果");
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

```

## 同步方法: 使用synchronized修饰的方法, 就叫做同步方法
同步方法: 使用synchronized修饰的方法, 就叫做同步方法,  保证A线程执行该方法的时候, 其他线程只能在方法外等着

```

synchronized public void doWork(){
   // TODO 
}

// 同步锁是谁:>?
对于非static 方法, 同步锁就是this, 谁调用这个方法就是谁.....

对于static方法, 我们使用当前方法所在类字节码对象..
```


***不要使用synchronized修饰run方法***，修饰之后，某一个线程就执行完了所有的功能.好比是多个线程出现串行.
解决方案:把需要同步操作的代码定义在一个新的方法中，并且该方
法使用synchronized修饰，再在run方法中调用该新的方法即可.


```

package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22. */     class Apple3 implements Runnable

{
    private int num = 500; // 苹果总数      @Override
  public void run() {

        for (int i = 0; i < 500; i++) {

            eat();
        }
    }

    synchronized private void eat()
    {
        if (num > 0)
        {
            System.out.println(Thread.currentThread().getName() + "吃了编号: " + num + "的苹果");
            num--;
        }
    }
}
public class SynchronizeMethodDemo {

    public static void main(String[] args)
    {
        Apple3 a = new Apple3();

        new Thread(a, "小A").start();
        new Thread(a, "小B").start();
        new Thread(a, "小C").start();
    }
}

```


## synchronized 优缺点

```

StringBuffer // 加了 synchronized 
StringBuilder // 没加

```


***synchronized 的好与坏:***
- 好处:保证了多线程并发访问时的同步操作,避免线程的安全性问题.
- 缺点:使用synchronized的方法/代码块的性能比不用要低一些
- 建议:尽量减小synchronized 的作用域

面试题:
1:StringBuilder和stringBuffer的区别
2:说说ArrayList和vector的区别HashMap和Hashtable 的区别.



