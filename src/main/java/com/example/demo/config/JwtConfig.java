package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {
        // OLD: return new JwtUtil(secretKeyBytes, expiration);
        return new JwtUtil(); // Use no-arg constructor
    }
}
