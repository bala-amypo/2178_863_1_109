package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // TEMPORARY hardcoded user (for project/demo)
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username("admin")
                .password("$2a$10$7qZ0E3nF6sSx9x5P9x2R0e7Z9k9uG5B3fXxW0d7y0lEJ9m7zj9n9O") 
                // password = admin
                .roles("USER")
                .build();
    }
}
