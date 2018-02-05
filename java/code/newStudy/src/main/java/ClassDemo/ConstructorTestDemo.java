package ClassDemo;

import java.lang.reflect.Constructor;

/**
 * Created by codew on 2018/1/29.
 */

class User{

    public User(){

    }

    public User(String name){

    }
    private User(String name, int age){

    }
}

//  获取构造器
public class ConstructorTestDemo {

    public static void main(String[] args) throws Exception{

//        getAll();
        getOne();
    }

    // 获取指定的构造器
    private static void getOne() throws Exception{
        // 1.获取构造器所在类的字节码对象
        Class<User> clz = User.class;

        // public Constructor<T> getConstructor(Class<?>... parameterTypes) :获取当前Class所表示类中指定的`一个public的构造器
        // 2. 获取public User()
        Constructor<User> con = clz.getConstructor();
        System.out.println(con);


        // public Constructor<T> get`DeclaredConstructor`(Class<?>... parameterTypes) :获取当前Class所表示类中指定的一个
        // public User(String name)
        con = clz.getConstructor(String.class);
        System.out.println(con);

//        private User(String name, int age)
        con = clz.getDeclaredConstructor(String.class, int.class);
        System.out.println(con);
    }

    private static void getAll(){

        // 1.获取构造器所在类的字节码对象
        Class<User> clz = User.class;

        // 2. 获取clz对象中所有的构造器
        // public Constructor<?>[] getConstructors():该方法只能获取当前Class所表示类`的public修饰的构造器`
//        Constructor<?>[] constructors = clz.getConstructors();
//        for (Constructor c: constructors) {
//            System.out.println(c);
//        }
        // public Constructor<?>[] getDeclaredConstructors():获取当前Class所表示类的***所有的构造器***,`和访问权限无关`
        Constructor<?>[] constructors = clz.getDeclaredConstructors();
        for (Constructor c: constructors) {
            System.out.println(c);
        }

    }
}
