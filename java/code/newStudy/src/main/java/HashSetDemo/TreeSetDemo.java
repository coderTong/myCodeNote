package HashSetDemo;

import lombok.Setter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by codew on 2018/2/1.
 */

//@Setter
//class TreeSetPerson implements Comparable
//{
//
//     int age;
//     String name;
//
//    public TreeSetPerson(String name, int age){
//
//        this.age = age;
//        this.name = name;
//
//    }
//
//    public String toString(){
//
//        return "TreeSetPerson [name" + name + ", age=" + age + "]";
//    }
//
//    @Override
//    public int compareTo(Object o) {
//
//        TreeSetPerson person = (TreeSetPerson)o;
//        int personAge = person.age;
//        int selfAge = this.age;
//
//        return  selfAge - personAge;
//    }
//}


@Setter
class TreeSetPerson
{

    int age;
    String name;

    public TreeSetPerson(String name, int age){

        this.age = age;
        this.name = name;

    }

    public String toString(){

        return "TreeSetPerson [name" + name + ", age=" + age + "]";
    }

}

/**
 * 用比较器比较
 *
 */

class NameLengthComparator implements Comparator<TreeSetPerson>{


    @Override
    public int compare(TreeSetPerson o1, TreeSetPerson o2) {

        // 如果名字相同
        if (o1.name.length() == o2.name.length()){

            int personAge = o2.age;
            int selfAge = o1.age;
            return  selfAge - personAge;
        }
        return o1.name.length() - o2.name.length();

//        if (o1.name.length() > o2.name.length()){
//
//            return 1;
//        }else if(o1.name.length() < o2.name.length()) {
//
//            return -1;
//        }
//
//        return 0;
    }
}

public class TreeSetDemo {

    public static void main(String[] args){


        // 按照名字长短 ====
        Set<TreeSetPerson> set = new TreeSet<>( new NameLengthComparator() );


        set.add(new TreeSetPerson("威尔史密斯", 24));
        set.add(new TreeSetPerson("杰森·斯坦森", 26));
        set.add(new TreeSetPerson("星爷", 28));
        set.add(new TreeSetPerson("李小龙", 29));
        set.add(new TreeSetPerson("西门楚云", 33));
        set.add(new TreeSetPerson("西门", 33));
        set.add(new TreeSetPerson("丁一", 33));
        set.add(new TreeSetPerson("丁三", 33));
        System.out.println(set);
    }



    public static void test2(){

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
