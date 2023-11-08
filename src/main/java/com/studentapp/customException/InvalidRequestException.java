package com.studentapp.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends Exception{
    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException() {
        super("Invalid Request !");
    }
}
