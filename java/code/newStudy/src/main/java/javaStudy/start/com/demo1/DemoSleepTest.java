package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */
public class DemoSleepTest {

    public static void main(String[] args) throws Exception
    {

        System.out.println("begin......");

        for (int i = 5; i >= 0; i--) {

            System.out.println("i=" + i);
            Thread.sleep(1000 );
        }

        System.out.println("end......");
    }
}
