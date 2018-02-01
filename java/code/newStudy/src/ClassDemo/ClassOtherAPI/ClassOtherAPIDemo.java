package ClassDemo.ClassOtherAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Created by codew on 2018/1/29.
 */

enum Gender{

    ONE,TWO,THREE
}

abstract public class ClassOtherAPIDemo {

    public static void main(String[] args) throws Exception{

        Class clz = ClassOtherAPIDemo.class;
        int mod = clz.getModifiers();
        String m = Modifier.toString(mod);
        System.out.println(m);

        System.out.println(clz.getName());
        System.out.println(clz.getSimpleName());
        System.out.println(clz.getPackage());
        System.out.println(clz.getPackage().getName());

        System.out.println(clz.getSuperclass());


        Constructor con = Gender.class.getDeclaredConstructor();
        con.setAccessible(true);
        con.newInstance();

    }
}
