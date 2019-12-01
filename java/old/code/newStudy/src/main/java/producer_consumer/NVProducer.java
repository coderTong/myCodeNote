package producer_consumer;

/**
 * Created by codew on 2018/1/23.
 */

// 消费者
public class NVProducer implements Runnable{

    private NVShareResource resource = null;

    public NVProducer(NVShareResource resource)
    {
        this.resource = resource;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            if (i % 2 == 0){

                resource.push("韦小宝", "男");

            }else {
                resource.push("貂蝉", "女");
            }

        }
    }
}
