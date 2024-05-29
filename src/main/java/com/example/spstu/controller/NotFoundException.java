package com.example.spstu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Stu_Class ID Not Found")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String errMsg) {
        super(errMsg);
    }
}
