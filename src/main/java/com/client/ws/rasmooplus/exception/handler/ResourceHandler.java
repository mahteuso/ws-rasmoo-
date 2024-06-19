package com.client.ws.rasmooplus.exception.handler;

import com.client.ws.rasmooplus.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler
    public ResponseEntity<String> notFoundException(NotFoundException nf){
        String notfound = nf.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notfound);
    }

}
