package com.portal.healthcare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException e){
        ErrorDetails errorDetails = new ErrorDetails("validation Error"
                , HttpStatus.NOT_ACCEPTABLE,e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<?> customException(CustomException exception){
        return new ResponseEntity<>(exception.getErrorDetails(), exception.errorDetails.getHttpStatus());
    }
}
