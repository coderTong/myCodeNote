package ExecutorDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * ========================================================>
 *
 * 2019年06月18日11:17:40
 * 线程池
 *
 *
 * */

public class ExecutorDemoMain {


//    Executor;
//    ExecutorService;

    public static void main(String[] args) {


        ExecutorService myService = Executors.newFixedThreadPool(2);


        ExeRunnable r = new ExeRunnable();

        myService.submit(r);
        myService.submit(r);
        myService.submit(r);
        myService.submit(r);
        myService.submit(r);
        myService.submit(r);

    }
}
