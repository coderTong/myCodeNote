package NoNameInnerClass;

public class NoNameInnerClassThread {


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 20; i++) {

                    System.out.println("斧头ongoing:" + i);
                }
            }
        }).start();

        for (int i = 0; i < 20; i++) {

            System.out.println("main:" + i);
        }
    }

}
