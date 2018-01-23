package javaStudy.start.com.demo1;

/**
 * Created by codew on 2018/1/22.
 */

class LogicException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public LogicException()
    {
        super();
    }

    public LogicException(String msg)
    {
        super(msg);
    }

    /**
     *
     * @param message 表示当前异常的原因/信息
     * @param cause 当前异常的根本原因
     * */
    public LogicException(String message, Throwable cause)
    {
        super(message, cause);
    }


}



public class demo7ExceptionSelf {

    private static String[] names = {"tom", "card", "Exception", "finall"};

    public static void main(String[] args){

        try {

            checkUserName("tom");

            System.out.println("注册成功");

        }catch (LogicException e){

            // 处理异常
            System.out.println("注册失败:"+ e.getMessage());
        }

    }

    public static boolean checkUserName(String userName)
    {
        for (String name: names){

            if (name.equals(userName)){

                throw new LogicException("亲" + name + "已近被注册了!");
            }
        }
        return true;

    }
}



