package com.codertomwu.my1029.MYInterface;

public interface MyInterfaceOne {

    public static final int TEST_MUN = 10;


    public abstract void method1();

    public void method2();

    abstract void method3();

    void method4();

    public default void method5(){

        System.out.println("接口升级， metho5");
    }

    public static void methodStatic(){

        System.out.println("接口静态方法");

    }


    // 私有方法
    // 普通私有
    private void methodCommod(){

    }
    private static void methodPStatic(){


    }

}
