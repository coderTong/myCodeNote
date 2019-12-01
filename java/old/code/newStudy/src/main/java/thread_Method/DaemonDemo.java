package thread_Method;

/**
 * Created by codew on 2018/1/24.
 */

class DaemonThread extends Thread
{

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 500; i++) {

            System.out.println(super.getName() + "-" + i);
        }
    }
}


public class DaemonDemo {

    public static void main(String[] args){

        System.out.println(Thread.currentThread().isDaemon());
//        System.out.println(Thread.currentThread().getName());


        for (int i = 0; i < 50; i++) {


            System.out.println("main:" + i);

            if (i == 10){
                DaemonThread t = new DaemonThread();
//                t.setDaemon(true); // 要先设置再启动否则挂@
                t.start();
            }

        }
    }
}
