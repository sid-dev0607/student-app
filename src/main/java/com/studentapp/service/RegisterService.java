package com.studentapp.service;

import com.studentapp.entity.User;
import com.studentapp.model.UserDto;
import com.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public User registerStudent(UserDto userDto){
        User user = new User();
        user.setEmailId(userDto.getEmailId());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}
