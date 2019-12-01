package thread_Method;

/**
 * Created by codew on 2018/1/24.
 */

public class ThreadSleepDemo {

    public static void main(String[] args) throws InterruptedException{

        for (int i = 10; i > 0; i--) {

            System.out.println("还剩" + i + "秒");
            Thread.sleep(1000);


            new Thread().join();
        }
        System.out.println("暴走");
    }

}
