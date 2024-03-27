package com.example.security.utils.exception;

import org.springframework.http.HttpStatus;

public class BusinessExceptionHandler extends RuntimeException{

    private HttpStatus httpStatus;

    // Header에 토큰값이 정의 되지 않은 경우
    public BusinessExceptionHandler(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
