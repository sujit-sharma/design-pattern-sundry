package com.sujit.javafeatures.javaio.impl;

public class IncorrectInformationInParamsException extends RuntimeException {
    public IncorrectInformationInParamsException(String msg){
        super(msg);
    }
    public IncorrectInformationInParamsException(String msg, Throwable cause){
        super(msg,cause);
    }
}
