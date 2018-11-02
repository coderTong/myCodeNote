package com.codertomwu.my1102.CenericClass;
/**
 * 泛型测试类
 * */
public class MyGenericTest<E> {

    private E name;
    private E age;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public E getAge() {
        return age;
    }

    public void setAge(E age) {
        this.age = age;
    }


    public <M> void method(M  m){

        System.out.println(m);
    }

    public static <G> void stMethod(G g){

        System.out.println(g);
    }
}
