package com.backward.common.exception;


public class WrongPasswordException extends Exception {

    public WrongPasswordException(){
        super("用户密码错误");
    }

}
