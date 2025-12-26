package com.example.demo.service.impl;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.AuthService;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void register(RegisterRequest request) {
        // Ensure RegisterRequest has getName(), getEmail(), getPassword()
        UserProfile user = new UserProfile();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userProfileRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        UserProfile user = userProfileRepository.findByEmail(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return new LoginResponse(token);
        }
        throw new RuntimeException("Invalid credentials");
    }
}
