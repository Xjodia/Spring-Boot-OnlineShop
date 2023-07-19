package com.example.springbootonlineshop.exception;

import com.example.springbootonlineshop.model.CustomError;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OnlineShopException extends RuntimeException {
    HttpStatus status;
    CustomError error;
}
