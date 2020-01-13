package com.shh.myjavaee.controller;

import com.shh.myjavaee.pojo.MyException;
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
