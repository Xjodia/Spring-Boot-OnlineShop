package com.example.springbootonlineshop.exception;

import com.example.springbootonlineshop.model.CustomError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OnlineShopException.class)
    public ResponseEntity<CustomError> handlerOnlineShopException(OnlineShopException exception){
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }
}
