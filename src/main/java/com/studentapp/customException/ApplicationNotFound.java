package com.studentapp.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationNotFound extends Exception{
    public ApplicationNotFound() {
        super("Application Not Found !");
    }

    public ApplicationNotFound(String message) {
        super(message);
    }
}
