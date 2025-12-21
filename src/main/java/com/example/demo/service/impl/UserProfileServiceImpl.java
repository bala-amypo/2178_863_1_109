package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    // Only inject the repository, remove PasswordEncoder
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    @Override
    public Optional<UserProfile> getUserById(Long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public UserProfile saveUser(UserProfile user) {
        // No password encoding, just save directly
        return userProfileRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userProfileRepository.deleteById(id);
    }
}
