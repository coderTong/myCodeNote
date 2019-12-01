package com.codertomwu.my1029.MYDuoTai;

public class MyDogMain {

    public static void main(String[] args) {

        System.out.println("多态测试。。。。");

        MyAnimal animal = new MYDog();
//        MyAnimal two = new MyCat();

        if (animal instanceof MyCat){

            MyCat cat = (MyCat) animal;
            cat.eatFish();
        }

        if (animal instanceof  MYDog){

            MYDog dog = (MYDog)animal;
            dog.eatShit();
        }
    }
}
