package com.company;

public class BusinessException extends IllegalStateException {

    public BusinessException(String msg) {
        super(msg);
    }
}
