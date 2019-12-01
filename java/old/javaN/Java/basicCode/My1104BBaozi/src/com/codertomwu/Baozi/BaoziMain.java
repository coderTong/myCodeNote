package com.codertomwu.Baozi;

public class BaoziMain {


    public static void main(String[] args) {

        Baozi bz = new Baozi();
        new Baozipu(bz).start();
        new Chihuo(bz).start();
    }
}
