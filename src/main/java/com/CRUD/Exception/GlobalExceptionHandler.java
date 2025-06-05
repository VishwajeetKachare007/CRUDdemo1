package com.CRUD.Exception;

import com.CRUD.Model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ErrorResponse> duplicateUserException(DuplicateUserException e){
        ErrorResponse errorResponse=new ErrorResponse(e.getMessage(),"DUPLICATE USER");

        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
}
