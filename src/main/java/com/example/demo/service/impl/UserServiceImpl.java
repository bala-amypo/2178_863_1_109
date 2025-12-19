package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserProfileRepository repository;

    public UserServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProfile register(UserProfile user) {
        return repository.save(user);
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }
}
