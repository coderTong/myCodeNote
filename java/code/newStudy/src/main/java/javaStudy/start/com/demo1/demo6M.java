package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

enum Weekday
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}


class Employee
{
    private Weekday restday;

    public Weekday getRestday()
    {
        return restday;
    }

    public void setRestday(Weekday restday)
    {
        this.restday = restday;
    }


}

enum NV_GlobalSingleton2
{
    INSTANCE;

    public String  getUserID()
    {
        return "324-EFFE-344";
    }
}

public class demo6M {

    public static void main(String[] args)
    {

//        System.out.println(Weekday.MONDAY.name());
//        System.out.println(Weekday.TUESDAY.name());
//        System.out.println(Weekday.WEDNESDAY.name());
//        System.out.println(Weekday.THURSDAY.name());

//        Weekday[] ws = Weekday.values();
//
//        for (Weekday wsO: ws) {
//            System.out.println(wsO.name());
//
//
//        }


        callSomeAPI(1);
//        try {
//            callSomeAPI(1);
//        } catch (IllegalStateException e) {
//            System.out.println(String.format(e.getMessage()));
//            callSomeAPI(0);
//        }


        try {

            Integer age = Integer.valueOf("123m");
            System.out.println(age);

        }catch (NumberFormatException e){

            e.printStackTrace();

            System.out.println("出现异常:" + e.getMessage());
            // System.exit(0); 干掉Java虚拟机才不会执行finally
        }finally {

            System.out.println("都会执行????");
        }


    }

    public static void callSomeAPI(int state) throws IllegalStateException {
        if(state > 0) {
            throw new IllegalStateException("state must <= 0");
        }
        // state is valid
        // do some jobs
    }

}
