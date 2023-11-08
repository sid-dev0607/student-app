package com.studentapp.config;

import com.studentapp.entity.User;
import com.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepsitory;

    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User logedInUser = userRepsitory.findByEmailId(emailId);
        if (logedInUser == null){
            throw new UsernameNotFoundException(emailId);
        }
        return new UserDetailsImpl(logedInUser);
    }
}
