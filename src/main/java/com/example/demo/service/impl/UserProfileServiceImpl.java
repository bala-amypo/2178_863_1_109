package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserProfileServiceImpl(UserProfileRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile createUser(UserProfile profile) {

        if (repository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        if (repository.existsByUserId(profile.getUserId())) {
            throw new BadRequestException("UserId already exists");
        }

        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        return repository.save(profile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserProfile updateUserStatus(Long id, boolean active) {
        UserProfile user = getUserById(id);
        user.setActive(active);
        return repository.save(user);
    }
}
