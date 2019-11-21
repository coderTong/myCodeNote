package ProducerConsumerModel;
/**
 *
 * ========================================================>
 *
 * 2019年06月18日11:13:21
 * 生产者消费者
 * .......low
 * */
public class ChiHuo extends Thread {

    private BaoZi bz;

    public BaoZi getBz() {
        return bz;
    }

    public void setBz(BaoZi bz) {
        this.bz = bz;
    }

    public ChiHuo(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }


    @Override
    public void run() {

        while (true){


            synchronized (bz){

                if (bz.flag == false){// 没有包子了

                    try {

                        bz.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                }

                System.out.println("吃货正在吃 " + bz.pi + bz.xian + "包子");
                bz.flag = false;
                bz.notify();;
            }

        }
    }
}
