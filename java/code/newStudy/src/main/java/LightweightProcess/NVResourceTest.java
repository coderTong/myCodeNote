package LightweightProcess;

/**
 * Created by codew on 2018/1/23.
 */
public class NVResourceTest {


    public static void main(String[] args)
    {
        NVShareResource resource = new NVShareResource();

        // 启动生产者
        new Thread(new NVProducer(resource)).start();
        // 启动消费者
        new Thread(new NVConsumer(resource)).start();
    }
}
