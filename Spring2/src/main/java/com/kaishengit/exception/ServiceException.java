package com.kaishengit.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(){};
    public ServiceException(String msg){
        super(msg);
    }

}
