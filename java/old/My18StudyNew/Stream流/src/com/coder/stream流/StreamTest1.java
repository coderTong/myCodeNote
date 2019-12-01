package com.coder.stream流;

import java.util.stream.Stream;

/**
 * Created by codew on 12/30/18.
 */
public class StreamTest1 {


    //定义一个方法,方法的参数传递Printable接口
    public static void printString(Printable p){
        p.print("Hello");
    }

    public static void main(String[] args) {



        /*
            使用方法引用优化Lambda
            对象是已经存在的MethodRerObject
            成员方法也是已经存在的printUpperCaseString
            所以我们可以使用对象名引用成员方法
         */
        //创建MethodRerObject对象
        StreamTestObj obj = new StreamTestObj();
        printString(obj::printUpperCaseString);


//        test2();
    }

    static void test2(){
        //创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
        //对Stream流中的元素进行过滤,只要姓张的人
        Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("张");});
        Stream<String> stream3 = stream.filter((String name)->{return name.startsWith("张");});
        //遍历stream2流
        stream2.forEach(name-> System.out.println(name));

        /*
            Stream流属于管道流,只能被消费(使用)一次
            第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕,就会关闭了
            所以第一个Stream流就不能再调用方法了
            IllegalStateException: stream has already been operated upon or closed
         */
        //遍历stream流
//        stream.forEach(name-> System.out.println(name));
    }

    static void test1(){
        Stream<String> stringStream = Stream.of("张三丰", "张无忌", "周至柔");

        stringStream.forEach(name-> System.out.println(name));
        stringStream.forEach(name-> System.out.println(name));
    }
}