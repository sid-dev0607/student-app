package com.studentapp.helper;

import com.studentapp.entity.User;
import com.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthHelper {
    @Autowired
    UserRepository userRepository;

    public User getLogdinUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByEmailId(userName);
        return user;
    }
}
