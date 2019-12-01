package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/21.
 */
public class demo2 {

    public static void main(String[] args)
    {

        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);

        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(123);
        Integer i4 = Integer.valueOf(123);
        System.out.println(i3 == i4);

        Integer i5 = 123; // 底层Integer.valueOf(123);
        Integer i6 = 123; // 底层Integer.valueOf(123);
        System.out.println(i5 == i6);

        System.out.println("===========================");

        Integer i7 = new Integer(200);
        Integer i8 = new Integer(200);

        System.out.println(i7 == i8);


// 享元 [-128, 127]
        Integer i9 = Integer.valueOf(200);
        Integer i10 = Integer.valueOf(200);
        System.out.println(i9 == i10);

    }
}
