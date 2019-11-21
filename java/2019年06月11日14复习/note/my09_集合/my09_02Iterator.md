# Iterator 迭代器

迭代： 即Collection集合元素的通用获取方式， 在取出元素之前先要判断集合中有没有元素， 如果有， 就把这个元素取出来， 继续判断， 如果还有就再取出来。 一直把集合中的所有元素全部取出来。

2018年11月2日09:05:56

个人理解： 为什么会有这种东西， 应该和集合的底层数据结构有关系。。。



Iterator 是个接口， 我们需要使用接口的实现类。。



Collection接口有一个方法， 



```java


Iterator<E> iterator() 
          返回在此 collection 的元素上进行迭代的迭代器。 

```

d



迭代器的使用

1. 用collection获取
2. 调用迭代器hasNext判断
3. 用next取出。。。



迭代器接口也是有泛型的， 迭代器的泛型跟着集合走， 集合是什么泛型，迭代器就是什么泛型

```java

package com.codertomwu.my1102.IteratorT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyIterator {

    public static void main(String[] args) {


        Collection<String> collection = new ArrayList<>();

        collection.add("java");
        collection.add("OC");
        collection.add("swift");
        collection.add("c");

        Iterator iterator = collection.iterator();
//        for (int i = 0; i < collection.size(); i++) {
//
//            if (iterator.hasNext()) {
//
//                System.out.println(iterator.next());
//            }
//
//        }

//        while (iterator.hasNext()){
//
//            System.out.println(iterator.next());
//        }


        // 增强for循环, 是java5以后的
        for (String str:
             collection) {

            System.out.println(str);
        }

    }

}


```



