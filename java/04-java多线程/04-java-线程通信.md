# 线程通信
线程通信:不同的线程执行不同的任务,如果这些任务有某种关系,线程之间必须能够通信,协调完成工作.


## code1

```
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 共享资源 
public class NVShareResource {

    private String name;
    private String gender;

    public void push(String name, String gender){

        this.name = name;
        this.gender = gender;

    }

    public void popup()
    {
        System.out.println(this.name + "-" + this.gender);
    }
}

//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 消费者 
public class NVProducer implements Runnable{

    private NVShareResource resource = null;

    public NVProducer(NVShareResource resource)
    {
        this.resource = resource;
    }

    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            if (i % 2 == 0){

                resource.push("韦小宝", "男");

            }else {
                resource.push("貂蝉", "女");
            }

        }
    }
}
//================

package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 消费者 
public class NVConsumer implements Runnable{

    // 共享的资源对象
  private NVShareResource resource = null;

    public NVConsumer(NVShareResource resource){

        this.resource = resource;
    }

    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            resource.popup();
        }
    }
}
//================

package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */ public class NVResourceTest {

    public static void main(String[] args)
    {
        NVShareResource resource = new NVShareResource();

        // 启动生产者
  new Thread(new NVProducer(resource)).start();
        // 启动消费者
  new Thread(new NVConsumer(resource)).start();
    }
}
```

## code2

```

//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 共享资源 public class NVShareResource {

    private String name;
    private String gender;

    public void push(String name, String gender){

        this.name = name;

        try {

            Thread.sleep(10);

        }catch (InterruptedException e){

            e.printStackTrace();
        }

        this.gender = gender;

    }

    public void popup()
    {
        try {

            Thread.sleep(10);

        }catch (InterruptedException e){

            e.printStackTrace();
        }

        System.out.println(this.name + "-" + this.gender);
    }
}
//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 消费者 public class NVConsumer implements Runnable{

    // 共享的资源对象
  private NVShareResource resource = null;

    public NVConsumer(NVShareResource resource){

        this.resource = resource;
    }

    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            resource.popup();
        }
    }
}

//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 消费者 public class NVProducer implements Runnable{

    private NVShareResource resource = null;

    public NVProducer(NVShareResource resource)
    {
        this.resource = resource;
    }

    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            if (i % 2 == 0){

                resource.push("韦小宝", "男");

            }else {
                resource.push("貂蝉", "女");
            }

        }
    }
}
//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */ public class NVResourceTest {

    public static void main(String[] args)
    {
        NVShareResource resource = new NVShareResource();

        // 启动生产者
  new Thread(new NVProducer(resource)).start();
        // 启动消费者
  new Thread(new NVConsumer(resource)).start();
    }
}
```
分析生产者和消费者案例存在的问题:

  建议在生产姓名和性别之间以及在打印之前使用Thread.sleep(10);使效果更明显.

  此时出现下面的情况:

```

貂蝉-男
韦小宝-女
貂蝉-男
貂蝉-女

```

问题1:出现姓别紊乱的情况.

- 解决方案:只要保证在生产姓名和性别的过程保持同步,中间不能被消费者线程进来取走数据.

- 可以使用同步代码块/同步方法/Lock机制来保持同步性.

问题2:应该出现生产一个数据,消费一个数据.

- 应该交替出现: 韦小宝-男-->貂蝉-女-->韦小宝-男-->貂蝉-女.....

- 解决方案: 得使用 等待和唤醒机制.



# 同步锁池

同步锁池:

- 同步锁`必须`选择多个线程共同的资源对象.

- 当前生产者在生产数据的时候(`先拥有同步锁`),其他线程就在`锁池中等待获取锁.`

- 当线程执行完同步代码块的时候,***就会释放同步锁***,其他线程开始抢锁的使用权.

# code3 -- 其他和上面一样. 这个解决了性别紊乱

```

//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 共享资源 public class NVShareResource {

    private String name;
    private String gender;

   synchronized public void push(String name, String gender){

        this.name = name;

        try {

            Thread.sleep(10);

        }catch (InterruptedException e){

            e.printStackTrace();
        }

        this.gender = gender;

    }

    synchronized public void popup()
    {
        try {

            Thread.sleep(10);

        }catch (InterruptedException e){

            e.printStackTrace();
        }

        System.out.println(this.name + "-" + this.gender);
    }
}
//================

//================

//================ 

```

# code4 等待和唤醒机制

线程通信-wait和notify方法介绍:

`java.lang.Object类提供类两类用于操作线程通信的方法.`

- wait():`执行该方法的线程对象`***释放同步锁***,JVM把该线程存放到`等待池中`,***等待其他的线程唤醒该线程.***

> 哪一个线程执行这个方法,它就释放掉同步锁, 自己就不再执行了,其他线程就有执行的机会了. 进入等待池, 等待其他线程唤醒,自己是不能唤醒自己的.

- notify:执行该方法的`线程唤醒在等待池中等待的任意一个线程`,把线程转到`锁池中`等待.

> 随机任意唤醒等待池里面的某一线程, 并不是说谁先进入等待池就先唤醒, 等待池===>锁池, 等待池中的对象 没有同步监听器不能执行代码, 而在锁池中的代码 有机会去获取锁,能够获取获取锁就能执行代码.
- notifyAll():执行该方法的线程唤醒在等待池中等待的所有的线程,把线程转到锁池中等待.

> 唤醒等待池中的所有线程 

注意:***上述方法只能被同步监听锁对象来调用,否则报错IllegalMonitorStateException..***
> 只能被同步监听锁对象来调用, 不能被线程对象调用.
------------------------------------------



```

多个线程只有使用相同的一个对象的时候,多线程之间才有互斥效果.

我们把这个用来做互斥的对象称之为,同步监听对象/同步锁.

-------------------------------------

同步锁对象可以选择任意类型的对象即可,只需要保证多个线程使用的是相同锁对象即可.

-------------------------------------

因为,只有同步监听锁对象才能调用wait和notify方法,所以,wait和notify方法应该存在于Object类中,而不是Thread类中.


```



假设A线程和B线程共同操作一个X对象(`同步锁`),A,B线程可以通过X对象的wait和notify方法来进行通信,流程如下:

- 1:当A线程执行`X对象的同步方法时`,A线程持有X对象的锁,B线程没有执行机会,`B线程在X对象的锁池中等待.`

- 2:A线程在同步方法中执行`X.wait()方法时,A线程释放X对象的锁`,进入A线程进入`X对象的等待池中.`

- 3:在X对象的`锁池中`等待锁的B线程`获取X对象的锁`,执行X的另一个同步方法.

- 4:B线程在同步方法中执行`X.notify()方法时`,JVM把A线程从X对象的等待池中移动到X对象的锁池中,等待获取锁.

- 5:B线程执行完同步方法,释放锁.A线程获得锁,继续执行同步方法.


```

//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 共享资源 
public class NVShareResource {

    private String name;
    private String gender;
    private boolean isEmpty = true; // 表示共享资源对象是否为空的状态    
synchronized public void push(String name, String gender){

        try {

            while (!isEmpty){// 当前isEmpty为false的时候, 不空等着消费者来获取    this.wait();// 使用同步锁对象来调用, 表示当前线程释放同步锁,进入等待池, 只能被其他线程唤醒
  }

            // -----开始生产------
  this.name = name;
            Thread.sleep(10);
            this.gender = gender;
            // -----生产结束-------
  isEmpty = false; // 设置共享资源中数据不为空
 // 生产结束唤醒消费者  this.notify();
        }catch (InterruptedException e){

            e.printStackTrace();
        }

    }

    synchronized public void popup()
    {
        try {

            while (isEmpty){ // 当前isEmpty为true的时候, 为空, 等待生产者来生产
 // 使用同步锁对象来调用, 表示当前线程释放同步锁, 进入等待池, 只能被其他线程所唤醒  this.wait();
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
//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 消费者 public class NVConsumer implements Runnable{

    // 共享的资源对象
  private NVShareResource resource = null;

    public NVConsumer(NVShareResource resource){

        this.resource = resource;
    }

    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            resource.popup();
        }
    }
}
//================
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */   // 消费者 public class NVProducer implements Runnable{

    private NVShareResource resource = null;

    public NVProducer(NVShareResource resource)
    {
        this.resource = resource;
    }

    @Override
  public void run() {

        for (int i = 0; i < 50; i++) {

            if (i % 2 == 0){

                resource.push("韦小宝", "男");

            }else {
                resource.push("貂蝉", "女");
            }

        }
    }
}

//================ 
package LightweightProcess;

/**
 * Created by codew on 2018/1/23. */ public class NVResourceTest {

    public static void main(String[] args)
    {
        NVShareResource resource = new NVShareResource();

        // 启动生产者
  new Thread(new NVProducer(resource)).start();
        // 启动消费者
  new Thread(new NVConsumer(resource)).start();
    }
}
```


# code5 线程通信-使用Lock和Condition接口:

线程通信-使用Lock和Condition接口:

***wait和notify方法,只能被同步监听锁对象来调用***,否则报错`IllegalMonitorStateException.`

那么现在问题来了,`Lock`机制根本就没有同步锁了,也就没有自动获取锁和自动释放锁的概念.

因为没有同步锁,所以Lock机制不能调用wait和notify方法.

解决方案:Java5中提供了Lock机制的同时提供了处理Lock机制的通信控制的Condition接口.

--------------------------------------------------------------------

从Java5开始,可以:

 1):使用Lock机制取代synchronized 代码块和synchronized 方法.

  2):使用Condition接口对象的await,signal,signalAll方法取代Object类中的wait,notify,notifyAll方法.

```

//================

//================

//================

//================ 

```




```

//================

//================

//================

//================ 

```




```

//================

//================

//================

//================ 

```
