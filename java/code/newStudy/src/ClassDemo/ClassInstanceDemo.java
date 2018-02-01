package ClassDemo;

/**
 * Created by codew on 2018/1/29.
 */
public class ClassInstanceDemo {

    String name = "";
    public static void main(String[] args) throws Exception{

        // 需求:获取java.util.Date 类的字节码对象
        // 方式一: 使用class属性
        Class<java.util.Date> clazz = java.util.Date.class;

        // 方式二:通过对象的getClass方法来获取, getClass是Object类中的方法
        /*
        */
        java.util.Date date = new java.util.Date();
        Class<?> clz = date.getClass();


        // 方式三:
        Class<?> clz2 = Class.forName("java.util.Date");


        System.out.println(clazz);
        System.out.println(clz);
        System.out.println(clz2);

        System.out.println(clazz == clz2);
        System.out.println(clazz == clz);
        System.out.println(clz2 == clz);
    }

}
