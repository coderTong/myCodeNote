package IODemo.ObjectiveStreamDemo;

/**
 * Created by codew on 2018/1/27.
 */
public class ObjectStreamUser  implements java.io.Serializable  {
    private static final long serialVersionUID = 1L;

    private String name;
    transient private String password;
    private int age;
    private String adrr;
    private String adrr2;

    public ObjectStreamUser(String name, String password, int age){

        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String toString()
    {
        return " User [name=" + name + " password =" + password + " age = " + age + "]";
    }
}
