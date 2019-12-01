package TimeWaitingDemo;

public class TimeWaitingDemoMain extends Thread{

    public static void main(String[] args) {

        new TimeWaitingDemoMain().start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            if ((i) % 10 == 0){
                System.out.println("-----------" + i);
            }

            System.out.println(i);

            try {

                Thread.sleep(1000);
                System.out.println("  线程睡眠1秒! \n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
