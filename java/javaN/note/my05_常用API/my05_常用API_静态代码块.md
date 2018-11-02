# 静态代码块



当第一次使用本类时执行以下，后面不再执行

用来一次性的对 静态成员变量进行赋值



```java

package com.codertomwu.my1027.MyString;

public class Person {

    static {
        System.out.println("静态的代码块执行");
    }

    public Person() {

        System.out.println("构造方法执行！");
    }
}


```

