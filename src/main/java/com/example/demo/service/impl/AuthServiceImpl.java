package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile; // Correct entity
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(RegisterRequest request) {
        UserProfile userProfile = new UserProfile(); // Use UserProfile, not User
        userProfile.setName(request.getName());
        userProfile.setEmail(request.getEmail());
        userProfile.setPassword(request.getPassword());

        userRepository.save(userProfile);
    }
}
