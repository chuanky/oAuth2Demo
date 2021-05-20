package com.example.oAuth2Demo.controller;

import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Chuanqi Shi
 * @date 2021/May/20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public String handleCredentialsException(Exception e, WebRequest request) {
        return e.getMessage();
//        return new ResponseEntity<>(e.getMessage() + request.getContextPath(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage() + request.getContextPath(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public String handleMalformedJwtExceptionException(Exception e, WebRequest request) {
        return e.getMessage();
    }
}
