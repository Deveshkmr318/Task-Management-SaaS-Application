package com.example.multitasker.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String msg){
        super(msg);
    }

}
