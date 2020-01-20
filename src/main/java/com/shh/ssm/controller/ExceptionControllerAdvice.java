package com.shh.ssm.controller;

import com.shh.ssm.pojo.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String Exception() {
        return "error";
    }

    @ExceptionHandler(MyException.class)
    public String MyException() {
        return "error";
    }
}
