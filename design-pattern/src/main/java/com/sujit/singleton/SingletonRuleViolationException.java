package com.sujit.singleton;

public class SingletonRuleViolationException extends RuntimeException {
    public SingletonRuleViolationException(String msg ){
        super(msg);
    }
}
