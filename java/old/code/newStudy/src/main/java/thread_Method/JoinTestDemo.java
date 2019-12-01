package thread_Method;

/**
 * Created by codew on 2018/1/24.
 */

class JoinClass extends Thread
{

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 50; i++) {

            System.out.println("join:" + i);
        }
    }
}


// 联合线程
public class JoinTestDemo {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("begin=======");

        JoinClass joinClass = new JoinClass(); // 创建
        for (int i = 0; i < 50; i++) {


            System.out.println("main:" + i);

            if (i == 10){
                // 启动join线程
                joinClass.start();
            }

            if (i == 20){

                joinClass.join(); // 强制运行该线程
            }
        }

        System.out.println("end =======");

    }
}
