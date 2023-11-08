package com.studentapp.service;

import com.studentapp.config.UserDetailsServiceImpl;
import com.studentapp.model.UserDto;
import com.studentapp.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtutil;
    @Autowired
    UserDetailsServiceImpl userDetailService;
    public String authenticate (UserDto userDto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmailId(), userDto.getPassword()));
            final UserDetails userDetails = userDetailService.loadUserByUsername(userDto.getEmailId());
            String username = userDetails.getUsername();
            String password = userDetails.getPassword();
            return jwtutil.generateToken( username, password);
        }
        catch (Exception e){
            throw new RuntimeException("Incorrect UserName or Password", e);
        }
    }
}
