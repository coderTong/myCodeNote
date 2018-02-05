package HashSetDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by codew on 2018/2/1.
 */
class ObjA{

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class ObjB{

    @Override
    public int hashCode() {
        return 1;
    }
}
class ObjC{

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}

public class HashSetDemo2  {

    public static void main(String[] args){


        Set set = new HashSet();
        set.add(new ObjA());
        set.add(new ObjA());
        set.add(new ObjB());
        set.add(new ObjB());
        set.add(new ObjC());
        set.add(new ObjC());

        System.out.println(set.size());
        System.out.println(set);


    }
}
