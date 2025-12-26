package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    // ⚠️ In real projects, move these to application.properties
    private static final String SECRET = "my-super-secret-key-my-super-secret-key";
    private static final long EXPIRATION_MS = 24 * 60 * 60 * 1000; // 1 day

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(SECRET.getBytes(), EXPIRATION_MS);
    }
}
