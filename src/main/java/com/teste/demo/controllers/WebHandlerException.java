package com.teste.demo.controllers;

import com.teste.demo.exception.TransactionException;
import com.teste.demo.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class WebHandlerException extends HandlerExceptionResolverComposite {

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<Error> processTransactionException(final HttpServletRequest req, final TransactionException ex) {
        return new ResponseEntity<Error>(new Error(ex.getMessage(), ex.getCode()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> processRuntimeException(final HttpServletRequest req, final RuntimeException ex) {
        return new ResponseEntity<Error>(new Error(ex.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}