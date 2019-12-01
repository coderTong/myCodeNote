# 函数式接口

# 第一章 函数式接口


**有且仅有一个抽象方法的接口**

```java

修饰符 interface 接口名称 {

  public abstract 返回值类型 方法名称(可选参数信息); // 其他非抽象方法内容

}


```

- @FunctionalInterface注解
  - 与 @Override 注解的作用类似，Java 8中专门为函数式接口引入了一个新的注解: @FunctionalInterface 。该注解可用于一个接口的定义上:

```java

@FunctionalInterface 

 public interface MyFunctionalInterface {
 void myMethod(); 

}

```


# 第二章 函数式编程

## 延迟执行

```java

package com.codertomwu.lambdafunction.Demo02;

/**
 * Created by codew on 11/13/18. */ public class Demo01Logger {

    public static void main(String[] args) {

        String msgA = "XX类,";
        String msgB = "XX方法,";
        String msgC = "XX错误,";

        log(1, msgA + msgB + msgC);
    }

    public static void log(int level, String msg){

        /**
 * 这段代码存在问题:无论级别是否满足要求，作为 log 方法的第二个参数，三个字符串一定会首先被拼接并传入方 法内，然后才会进行级别判断。如果级别不符合要求，那么字符串的拼接操作就白做了，存在性能浪费。 */  if (level == 1){

            System.out.println(msg);
        }
    }

}

```



```java

package com.codertomwu.lambdafunction.Demo02;

/**
 * Created by codew on 11/13/18. */ public class Demo02LoggerLambda {

    public static void main(String[] args) {

        String msgA = "XX类,";
        String msgB = "XX方法,";
        String msgC = "XX错误,";

//        log(1, () -> msgA + msgB + msgC);    log(2,()->{

            System.out.println("Lambda执行了嘛?");

            return msgA + msgB + msgC;
        });
    }

    public static void log(int leve1, MessageBuilder builder){

        if (leve1 == 1){

            System.out.println(builder.builderMessage());
        }
    }
}






package com.codertomwu.lambdafunction.Demo02;

/**
 * Created by codew on 11/13/18. */   @FunctionalInterface public interface MessageBuilder {

    String  builderMessage();
}

```



## 使用Lambda作为参数和返回值

```java

package com.codertomwu.lambdafunction.Demo03;

/**
 * Created by codew on 11/13/18. */ public class Demo03Runnable {

    public static void main(String[] args) {

        startThread(()-> System.out.println("开辟新线程执行任务了?" + Thread.currentThread().getName()));
    }

    public static void startThread(Runnable task){

        new Thread(task).start();
    }
}

```


```java

package com.codertomwu.lambdafunction.Demo03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by codew on 11/13/18. */ public class Demo04Comparator {

    public static Comparator<String> myComparatorTest(){

        return (a,b) -> b.length() - a.length();
    }

    public static void main(String[] args) {

        String[] array = {"abc", "ab", "abcd"};

        System.out.println(Arrays.toString(array));
        Arrays.sort(array, myComparatorTest());
        System.out.println(Arrays.toString(array));

    }
}

```




# 第三章 常用的函数式接口
JDK提供了大量常用的函数式接口以丰富Lambda的典型使用场景，它们主要在 java.util.function 包中被提供。 下面是最简单的几个接口及使用示例。


## 3.1 Supplier接口

```java

package com.codertomwu.lambdafunction.Demo04;

import java.util.function.Supplier;

/**
 * Created by codew on 11/13/18. */ public class Demo02Supplier {

    public static void main(String[] args) {

        int[] arr = {12,23,9,99,0,3};

        int maxValue = getMax(()->{

            int max = 0;

            for (int r: arr) {

                if (r > max){

                    max = r;
                }
            }

            return max;

        });

        System.out.println(maxValue);
    }

    public static int getMax(Supplier<Integer> supplier){

        return supplier.get();
    }
}

```


```java

package com.codertomwu.lambdafunction.Demo04;

import java.util.function.Supplier;

/**
 * Created by codew on 11/13/18. */     /*
 常用的函数式接口 java.util.function.Supplier<T>接口仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。   Supplier<T>接口被称之为生产型接口,指定接口的泛型是什么类型,那么接口中的get方法就会生产什么类型的数据 */   public class Demo05Supperlier {

    public static void main(String[] args) {

        String msgA = "Hello";
        String msgB = "World";

        System.out.println(getString(()-> msgA + msgB));
    }

    public static String getString(Supplier<String> function){

        return function.get();
    }
}

```


## 3.3 Consumer接口, 消费

上面的是生产, 下面的是消费



## 3.4 练习:格式化打印信息

## 3.5 Predicate接口

## 3.6 练习:集合信息筛选

## 3.7 Function接口

## 3.8 练习:自定义函数模型拼接