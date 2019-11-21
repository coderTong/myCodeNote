package BufferedStream;

import java.io.*;
import java.util.HashMap;

public class BufferedStreamMain {


    public static void main(String[] args) throws IOException {


        testInputStreamGBKToUTF();
    }


    /**
     *
     * 2019年06月25日14:57:09
     * 转换流
     * 写文件.....
     * 狗日的东方能源给我争了口气 + 8%
     * */
    public static void testBufferedOutputDemo() throws IOException {

        String fileName = "转码01.txt";

        OutputStreamWriter osw = new OutputStreamWriter( new FileOutputStream(fileName) );

        osw.write("吃饭了嘛");
        osw.close();

        String filenName2 = "gbk02.txt";
        OutputStreamWriter osw2 = new OutputStreamWriter( new FileOutputStream( filenName2), "GBK" );

        osw2.write("吃饭了嘛, 要不对付一口?吃不吃?");
        osw2.close();
    }



    public static void testInputStreamReaderDemo() throws IOException {

        InputStreamReader reader01 = new InputStreamReader(new FileInputStream("gbk02.txt"));
        InputStreamReader reader02 = new InputStreamReader( new FileInputStream("gbk02.txt"), "GBK");

        int read;

        while ( (read = reader01.read()) != -1){

            System.out.println((char) read);

        }

        while ( (read = reader02.read()) != -1){

            System.out.println("GBK:" + (char) read);
        }

        reader01.close();
        reader02.close();
    }


    /**
     * 2019年06月25日15:24:13
     *
     *
     * */

    public static void testInputStreamGBKToUTF() throws IOException {

        InputStreamReader reader01 = new InputStreamReader( new FileInputStream("gbk02.txt"), "GBK" );
        OutputStreamWriter writer01 = new OutputStreamWriter( new FileOutputStream("utk.txt") );

        int read;
        char[] chars = new char[1024];

        while ( ( read = reader01.read(chars) ) != -1 ){


            writer01.write(chars, 0, read);
        }


        reader01.close();
        writer01.close();
    }



    public static void testBufferedtt() throws IOException {

        //
        HashMap<String, String> lineMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader("b.txt"));
        BufferedWriter bw = new BufferedWriter( new FileWriter("出师表.txt") );

        String line = null;

        while ( (line = br.readLine()) != null  ){

            String[] split = line.split("\\.");
            lineMap.put( split[0], split[1]);
        }

        br.close();

        for (int i = 1; i < lineMap.size(); i++) {

            String key = String.valueOf(i);
            String value = lineMap.get(key);

            bw.write(key + "." + value);
            bw.newLine();
        }

        bw.close();


    }


    public static void testBufferedWriter() throws IOException {

        BufferedWriter writer = new BufferedWriter( new FileWriter("/Users/codew/Desktop/Net/java/将敬酒.txt") );
        BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
        
        String line = null;

        while ( ( line = bufferedReader.readLine() ) != null ){

            writer.write(line);
            writer.newLine();
        }

        writer.close();
        bufferedReader.close();
    }


    public static void testBufferedReader() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));

        String line = null;

        while ( ( line = bufferedReader.readLine() ) != null ){

            System.out.println(line);
            System.out.println("----------------");
        }

        bufferedReader.close();
    }




    public static void testBufferedInputStream(){

        long start = System.currentTimeMillis();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("dll.mp4"))) {
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/codew/Desktop/Net/java/mimifile.mp4"))) {


                int len;
                byte[] bytes = new byte[8*1024];
                while ( ( len = bis.read(bytes) ) != -1){

                    bos.write(bytes,0,len);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("所需时间:" + (end - start) + " 毫秒");

    }



}
