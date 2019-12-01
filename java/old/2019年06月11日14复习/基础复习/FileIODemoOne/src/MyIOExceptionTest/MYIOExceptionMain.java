package MyIOExceptionTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MYIOExceptionMain {


    public static void main(String[] args) throws IOException {


        jdk9IOExcepation();
        //
        ///
        ///y

    }


    private static void jdk9IOExcepation() throws IOException {

//        final FileReader fr = new FileReader("fw.txt");
//
//        FileWriter fw = new FileWriter("out.txt");
//
//
//        try (fr; fw){
//
//            int b;
//
//            while ( (b = fr.read() ) != -1 ){
//
//                fw.write(b);
//            }
//        }catch (IOException e){
//
//            e.printStackTrace();
//        }

    }

    /**
     * 还可以使用JDK7优化后的 try-with-resource 语句，该语句确保了每个资源在语句结束时关闭。所谓的资源
     * (resource)是指在程序完成后，必须关闭的对象。 格式:
     * try (创建流对象语句，如果多个,使用';'隔开) { // 读写数据
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     */
    private static void jdk7IOExcepation() {


        try (FileWriter fileWriter = new FileWriter("fw.txt", true)) {

            fileWriter.write("\n今晚吃火锅...");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    private static void jdk7BeforeIOExcepation() {

        FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter("fw.txt");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {


            try {

                if (fileWriter != null) {

                    fileWriter.close();
                    ;
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }
}
