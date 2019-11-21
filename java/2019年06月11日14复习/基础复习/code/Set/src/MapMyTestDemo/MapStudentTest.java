package MapMyTestDemo;

import java.util.Objects;

/**
 * Created by codew on 6/12/19.
 */
public class MapStudentTest {

    private String name;
    private  int age;


    public MapStudentTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MapStudentTest() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj){

            return true;
        }

        if (obj == null || getClass() != obj.getClass()){

            return false;
        }

        MapStudentTest studentTest = (MapStudentTest) obj;

        return age == studentTest.age  && Objects.equals(name, studentTest.name);

    }


    @Override
    public int hashCode() {


        return Objects.hash(name, age);
    }
}
