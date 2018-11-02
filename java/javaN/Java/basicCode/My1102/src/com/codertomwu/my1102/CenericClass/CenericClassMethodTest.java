package com.codertomwu.my1102.CenericClass;

public class CenericClassMethodTest <I>  implements GenericInterface<I> {


    @Override
    public void method(I i) {

        System.out.println("接口用什么实现类就用什么");
    }
}
