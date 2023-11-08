package com.studentapp.controller;

import com.studentapp.model.UserDto;
import com.studentapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public String authUser(@RequestBody UserDto userDto) throws Exception{
        try {
            return authService.authenticate(userDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
