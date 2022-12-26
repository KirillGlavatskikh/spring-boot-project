package com.example.springbootproject.controller;

import com.example.springbootproject.exception.ArgumentException;
import com.example.springbootproject.exception.NullPointer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(ArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String argumentException(ArgumentException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NullPointer.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String nullPointer(NullPointer e) {
        return e.getMessage();
    }
}
