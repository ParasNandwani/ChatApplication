package com.exception;

import com.common.base.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChatApplicationExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ServiceResponse> exception(){
        //retrun new  ResponseEntity<ServiceResponse>(HttpStatus.EXPECTATION_FAILED);
        return null;
    }
}
