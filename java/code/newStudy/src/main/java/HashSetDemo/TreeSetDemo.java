package HashSetDemo;

import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by codew on 2018/2/1.
 */

@Setter
class TreeSetPerson implements Comparable
{

    private int age;
    private String name;

    public TreeSetPerson(String name, int age){

        this.age = age;
        this.name = name;

    }

    public String toString(){

        return "TreeSetPerson [name" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Object o) {

        TreeSetPerson person = (TreeSetPerson)o;
        int personAge = person.age;
        int selfAge = this.age;

        return  selfAge - personAge;
    }
}


public class TreeSetDemo {

    public static void main(String[] args){


        Set<TreeSetPerson> set = new TreeSet<TreeSetPerson>();

        set.add(new TreeSetPerson("周星驰", 28));
        set.add(new TreeSetPerson("李小龙", 29));
        set.add(new TreeSetPerson("威尔史密斯", 24));
        set.add(new TreeSetPerson("杰森·斯坦森", 26));

        System.out.println(set);
    }




    public static void test(){

        TreeSet<String> set = new TreeSet<>();

        set.add("Y");
        set.add("a");
        set.add("1");
        set.add("S");
        set.add("4");
        set.add("H");
        set.add("C");

        System.out.println(set);

        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.headSet("4"));
    }
}
