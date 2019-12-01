package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */




class Outter
{
    String name = "Outter.name";


    public void testOutter()
    {
        System.out.println(this.new Inner().age);
    }

    // 实例内部类
    class Inner
    {
        int age = 17;
        String name = "Inner.name";

        public void test()
        {
            String name = "Inner.test.name";


            System.out.println(name);
            System.out.println(this.name);
            System.out.println(new Outter().name);
        }
    }
}


public class demo5ClassInClass {

    public static void main(String[] args){

        Outter.Inner inner = new Outter().new Inner();
        inner.test();
    }

}



