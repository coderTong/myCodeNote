```

class NV_GlobalSingleton
{
    // 1.必须在类中,自己先创建一个对象
  private static final NV_GlobalSingleton instance = new NV_GlobalSingleton();

    // 2.私有化自身的构造器
  private NV_GlobalSingleton(){}

    // 3.提供获取方法
  public static NV_GlobalSingleton getInstance()
    {
        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

```


```
enum NV_GlobalSingleton2
{
    INSTANCE;

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

```

```

enum NV_GlobalSingleton3
{
    INSTANCE;

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

// 单例模式-饿汉式 
public class NV_GlobalSingleton4
{
    private NV_GlobalSingleton4(){}

    private static NV_GlobalSingleton4 instance = new NV_GlobalSingleton4();
    public static NV_GlobalSingleton4 getInstance(){

        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

// 单例模式-懒汉式 
public class NV_GlobalSingleton5
{
    private NV_GlobalSingleton5(){}

    private static NV_GlobalSingleton5 instance = null;

    synchronized public static NV_GlobalSingleton5 getInstance(){

        if (instance == null){

            instance = new NV_GlobalSingleton5();
        }
        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    } 
}

/**
上述代码使用同步方法, 已经解决了懒汉式的线程安全问题

但是synchronized的作用域太大, 损耗性能,-----> 尽量减小synchronized的作用域.

双重检查锁方案
解决
*/

// 单例模式-懒汉式-双重检查锁 
public class NV_GlobalSingleton6
{
    private NV_GlobalSingleton6(){}

    private static NV_GlobalSingleton6 instance = null;

    public static NV_GlobalSingleton6 getInstance(){

        if (instance == null){

            synchronized (NV_GlobalSingleton6.class){

                if (instance == nil)
                {
                    instance = new NV_GlobalSingleton6();
                }
            }

        }
        return instance;
    }

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

```


![java-单例模式-01](image/java-%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F-01.png)

