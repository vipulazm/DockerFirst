package org.vipul.dockerfirst.exception;

public class NameNotFoundException extends RuntimeException{

    public NameNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public NameNotFoundException(String message){
        super(message);
    }
}
