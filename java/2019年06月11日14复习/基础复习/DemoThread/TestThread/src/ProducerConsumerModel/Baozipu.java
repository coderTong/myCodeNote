package ProducerConsumerModel;


/**
 *
 * ========================================================>
 *
 * 2019年06月18日11:13:21
 * 生产者消费者
 * .......low
 * */


public class Baozipu extends Thread {


    private BaoZi bz;

    public BaoZi getBz() {
        return bz;
    }

    public void setBz(BaoZi bz) {
        this.bz = bz;
    }

    public Baozipu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {

        int count = 0;

        while (true){

            synchronized (bz){

                if (bz.flag == true){// 有包子

                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("包子铺开始做包子");

                if (count%2 == 0){

                    bz.pi = "冰皮";
                    bz.xian = "五仁";
                }else {
                    bz.pi = "薄皮";
                    bz.xian = "猪肉大葱";
                }

                count++;

                bz.flag = true;
                System.out.println("包子造好了: " + bz.pi + bz.xian);
                System.out.println("吃货可以过来吃了!");

                bz.notify();

            }
        }

    }
}



















