package ThreadRunnable;

public class MyRunnableMain {

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();

        Thread t = new Thread(myRunnable, "小气");
        t.start();

        for (int i = 0; i < 20; i++) {

            System.out.println("旺财" + i);
        }

    }
}
