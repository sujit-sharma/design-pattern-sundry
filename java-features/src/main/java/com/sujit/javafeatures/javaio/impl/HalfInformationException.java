package com.sujit.javafeatures.javaio.impl;

public class HalfInformationException extends RuntimeException {
    public HalfInformationException(String msg){
        super(msg);
    }
    public HalfInformationException(String msg, Throwable cause){
        super(msg,cause);
    }
}
