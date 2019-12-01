package com.codertomwu.MyException;

/**
 * 自定义异常类
 *注意：
 *自定义异常类一般都是Exception结尾。。。
 * 自定义异常类必须继承Exception(编译异常)或者继承RuntimeException（运行时异常）
 *
 * */
public class RegisterException extends Exception/** 或者继承RuntimeException */  {

    public RegisterException() {
    }

    public RegisterException(String s) {
        super(s);
    }
}
