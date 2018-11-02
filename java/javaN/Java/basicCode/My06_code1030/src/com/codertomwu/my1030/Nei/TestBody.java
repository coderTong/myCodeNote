package com.codertomwu.my1030.Nei;

public class TestBody implements INiName {

    @Override
    public void testN() {

    }

    @Override
    public void test2() {

    }

    class Heart{

        public void say(){

            System.out.println("我的名字：" + name);
        }
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){

    }

}
