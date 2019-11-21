package LambdaDemo001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo001Main {


    public static void main(String[] args) {




        lambdaMore();

    }


    /***
     * =================================================================================================================>
     *
     * 多参数lambda
     * 2019年06月18日16:19:18
     *
     * 排序使用, 等于说有参数有返回值.....
     *
     * */

    /**
     *  lambda
     *
     *
     * */

    private static void lambdaMore(){

//        invokeCalc(120,130, (int a, int b) ->{
//
//            return b-a;
//        });

        // 省略写法

//        invokeCalc(12,33, (int a, int b) -> a+b );

//        invokeCalc(12,33, (a, b) -> a+b );



        logTest("hhh", (t)->{

            return t + "  " + "2019年06月18日16:46:34";
        });


        logTest("竹笋", b->{

            return b + " " + "2019年06月18日16:55:34";
        });
    }




    private static void summTest(){

        invokeCalc(20, 20, new Calculator() {

            @Override
            public int calc(int a, int b) {
                return a - b;
            }
        });
    }

    private static void logTest(String name, LogDemoTest test){

        String resultName = test.makeLog(name);

        System.out.println(resultName);
    }

    private static void invokeCalc(int a, int b, Calculator calculator){

        int result = calculator.calc(a,b);

        System.out.println(result);
    }




    /***
     * =================================================================================================================>
     * 2019年06月18日15:47:41
     *
     * 排序使用, 等于说有参数有返回值.....
     *
     * */

    private void lambdaSort(){

        Person[] array = {
                new Person("热狗", 40),
                new Person("张震岳", 43),
                new Person("pgone", 33)

        };

        Arrays.sort(array, (Person o1, Person o2)->{

            return o1.getAge() - o2.getAge();
        });


        for (Person person: array) {

            System.out.println(person.getAge());
        }
    }

    /**
     *2019年06月18日16:11:09
     * 传统排序
     *
     * */
    private void test001(){

        Person[] array = {
                new Person("热狗", 40),
                new Person("张震岳", 43),
                new Person("pgone", 33)

        };


        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                return o1.getAge() - o2.getAge();
            }
        };


        Arrays.sort(array, comparator);


        for (Person person: array) {

            System.out.println(person.getAge());
        }

    }







    /**
     *==================================================================================================================>
     * Lambda初级用法
     * 2019年06月18日15:44:26
     * low
     *
     * */

    private static void lambdaBaseUse(){


        System.out.println(Thread.currentThread().getName());


        new Thread(()->{

            System.out.println("你猜怎么着, 拉姆达起来........");

            System.out.println(Thread.currentThread().getName());

        }).start();

        new Thread(()->{

            System.out.println("你猜怎么着, 拉姆达起来........");

            System.out.println(Thread.currentThread().getName());

        }).start();


        invokeCook((()->{

            System.out.println("吃饭了!!!!!");
        }));
    }


    /**
     * Lambda
     * 2019年06月18日15:32:52
     * 无返回值无参数
     *
     * */
    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }

}
