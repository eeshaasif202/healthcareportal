package com.portal.healthcare.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
public class CustomException extends RuntimeException{
    public ErrorDetails errorDetails;
    public CustomException(String message, String details, HttpStatus httpStatus){
        this.errorDetails = new ErrorDetails(message,httpStatus,details);}
}
