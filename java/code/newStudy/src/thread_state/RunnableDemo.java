package thread_state;

/**
 * Created by codew on 2018/1/24.
 */

class Other extends Thread
{
    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 10; i++) {

            System.out.println("Other --" + i);
        }
    }
}



public class RunnableDemo {

    public static void main(String[] args) throws IllegalThreadStateException{
        Other other = new Other();
        for (int i = 0; i < 100; i++) {

            System.out.println("main --" + i);

            if (i == 10){

                //
                other.start();
            }
        }

        if (!other.isAlive()){

            // 线程死了不能复生
            other.start();
        }
//
//        Other other = new Other();
//        other.start();
//        other.start();
    }
}
