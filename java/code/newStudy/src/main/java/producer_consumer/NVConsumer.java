package producer_consumer;

/**
 * Created by codew on 2018/1/23.
 */

// 消费者
public class NVConsumer implements Runnable{

    // 共享的资源对象
    private NVShareResource resource = null;

    public NVConsumer(NVShareResource resource){

        this.resource = resource;
    }

    
    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            resource.popup();
        }
    }
}
