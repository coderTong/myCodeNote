package ThreadOneDemo;

public class MyThreadMain {

    public static void main(String[] args) {

        MyThread myThread = new MyThread("thread one");

        myThread.start();

        for (int i = 0; i < 10; i++) {

            System.out.println("main Thread" + i);
        }


    }

}
