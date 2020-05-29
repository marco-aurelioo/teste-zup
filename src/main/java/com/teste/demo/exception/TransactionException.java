package com.teste.demo.exception;

public class TransactionException extends RuntimeException {

    private int code;

    public TransactionException(String msg, int code ){
        super(msg);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
