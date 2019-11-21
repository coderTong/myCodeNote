package ProducerConsumerModel;


/**
 *
 * ========================================================>
 *
 * 2019年06月18日11:13:21
 * 生产者消费者
 * .......low
 * */


public class ProducerConsumerModelMain {


    public static void main(String[] args) {


        BaoZi baoZi = new BaoZi();
        ChiHuo ch = new ChiHuo("猫咪Cat", baoZi);
        Baozipu baozipu = new Baozipu("庆丰包子铺", baoZi);

        ch.start();
        baozipu.start();

    }
}
