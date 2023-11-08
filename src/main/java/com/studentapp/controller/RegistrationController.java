package com.studentapp.controller;

import com.studentapp.customException.InvalidRequestException;
import com.studentapp.entity.User;
import com.studentapp.model.UserDto;
import com.studentapp.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    RegisterService registerService;
    @PostMapping("/register")
    public ResponseEntity<User> registerStudent(@RequestBody UserDto userDto) throws Exception{
        try {
            User user = registerService.registerStudent(userDto);
            return new ResponseEntity<User>(user,HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Invalid Request ",e);
            throw new InvalidRequestException("Invalid Request  " + e.getMessage());
        }
    }
}
