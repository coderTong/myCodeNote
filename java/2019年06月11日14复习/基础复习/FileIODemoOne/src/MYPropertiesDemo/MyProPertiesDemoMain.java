package MYPropertiesDemo;

import sun.text.normalizer.UTF16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class MyProPertiesDemoMain {


    public static void main(String[] args) throws IOException {


    }

    private static void myProperties2() throws IOException {

        Properties properties = new Properties();

        properties.load(new FileReader("pp.properties"));

        Set<String> strings = properties.stringPropertyNames();

        for (String key: strings) {

            System.out.println(key + "--" + new String(properties.getProperty(key)) );
        }
    }

    private static void myProperties(){

        Properties properties = new Properties();

        properties.setProperty("filename", "fw.txt");
        properties.setProperty("length", "3242");
        properties.setProperty("location", "a.txt");

        System.out.println(properties);
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        Set<String> strings = properties.stringPropertyNames();

        for (String key: strings) {

            System.out.println(key + " -- "+ properties.getProperty(key));
        }
    }
}
