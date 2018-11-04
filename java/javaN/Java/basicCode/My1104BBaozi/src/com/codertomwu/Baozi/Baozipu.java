package com.codertomwu.Baozi;

public class Baozipu extends Thread {

    private Baozi bz;

    public Baozipu(Baozi bz) {
        this.bz = bz;
    }

    // 生产包子
    @Override
    public void run() {

        int count = 0;

        while (true){

            synchronized (bz){

                // 判断包子状态
                if (bz.flag == true){

                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                // 被唤醒之后执行， 包子铺生产包子
                if (count%2 == 0){

                    bz.pi = "薄皮";
                    bz.xian = "三鲜";
                }else {

                    bz.pi = "冰皮";
                    bz.xian = "豆沙";
                }
                count++;
                System.out.println("包子铺正在生产：" + bz.pi + bz.xian + "包子");


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 生产好包子
                bz.flag = true;
                bz.notify();

                System.out.println("包子铺生产好了： " + bz.pi + bz.xian + "包子， 可以吃了");
            }
        }

    }
}
