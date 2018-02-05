package javaStudy.start.com.demo1;

import java.lang.Thread;

/**
 * Created by codew on 2018/1/22.
 */


class MusicThread extends Thread
{


    public static void playMusic()
    {
        for (int i = 0; i < 50; i++) {

            System.out.println("播放音乐:" + i);
        }
    }


    @Override
    public void run() {
        super.run();

        playMusic();
    }
}




public class DemoThread {

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
                // 创建线程并启动
                MusicThread t = new MusicThread();
                t.start();
            }
            System.out.println("打游戏:" + i);
        }
   }

}
