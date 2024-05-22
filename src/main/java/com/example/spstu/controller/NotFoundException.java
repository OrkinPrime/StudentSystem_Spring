package com.example.spstu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "学生信息错误")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String errMsg) {
        super(errMsg);
    }
}
