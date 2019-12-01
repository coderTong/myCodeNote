package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */


class Obj1
{
    public void callSomeAPI(int state) throws IllegalStateException {
        if(state > 0) {
            throw new IllegalStateException("state must <= 0");
        }
        // state is valid
        // do some jobs
    }
}

class Obj2
{

    public Obj1 _obj1;

    Obj2()
    {
        _obj1 = new Obj1();
    }

    public void test(int state)
    {
        _obj1.callSomeAPI(state);
    }
}


class Obj3
{
    public Obj2 _obj2;

    Obj3()
    {
        _obj2 = new Obj2();
    }

    public void test(int state)
    {
        _obj2.test(state);
    }
}
public class demo7ThrowTest {

    public static void main(String[] args)
    {
        try {

            Obj3 _obj3 = new Obj3();
            _obj3.test(4);
        }catch (RuntimeException e){

            e.printStackTrace();
        }

        System.out.println("===============>");
    }
}
