package com.codertomwu.my1029.MYInterface;

public class MyInterfaceMain {

    public static void main(String[] args) {

        System.out.println(" 接口呵呵。。。 ");

        System.out.println(MyInterfaceOne.TEST_MUN);

        MyInterfaceImp i1 = new MyInterfaceImp();
        i1.method5();
//
        MyInterfaceOne.methodStatic();
        MyInterfaceImpB iB = new MyInterfaceImpB();
        iB.method5();



    }
}
