package com.ddey.accounts.exception;

import com.ddey.accounts.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExist.class)
    public ResponseEntity<ErrorDto> handleCustomerAlreadyExist(CustomerAlreadyExist exception,
                                                               WebRequest webRequest) {

        ErrorDto errorDto = new ErrorDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
