package HashSetDemo;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by codew on 2018/2/1.
 */
@Setter
//@AllArgsConstructor
@ToString
class StudentD{

    private int sn;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentD studentD = (StudentD) o;

        return sn == studentD.sn;
    }

    @Override
    public int hashCode() {
        return sn;
    }

    public StudentD(int sn, String name, int age){

        super();

        this.age = age;
        this.name = name;
        this.sn = sn;
    }


    @Override
    public String toString() {

        return "StudentD [sn=" + sn + ", name = " + name + ", age = " + age + "]";
    }


}

public class HashSetDemo3 {

    public static void main(String[] args){

        Set set = new HashSet();

        set.add(new StudentD(1, "周杰伦", 17));
        set.add(new StudentD(1, "周杰伦", 17));
        set.add(new StudentD(1, "周星驰", 17));
        set.add(new StudentD(3, "周大福", 17));
        set.add(new StudentD(4, "周冬雨", 17));
        set.add(new StudentD(5, "周润发", 17));


        System.out.println(set.size());
        System.out.println(set);


//        System.out.println(new StudentD(5, "周润发", 17));
    }
}
