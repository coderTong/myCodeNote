package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */
public class ImplementsRunnableDemo {

    public static void main(String[] args)
    {
        System.out.println("begin........");

        playGame();

        System.out.println("end........");
    }




    public static void playGame()
    {
        for (int i = 0; i < 50; i++) {

            if (i == 10)
            {
               new Thread(new Runnable() {
                   @Override
                   public void run() {

                       for (int i = 0; i < 50; i++) {

                           System.out.println("播放音乐:" + i);
                       }

                   }
               }).start();

            }
            System.out.println("打游戏:" + i);
        }
    }


}
