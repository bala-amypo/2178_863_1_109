package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection for repository and password encoder
    public UserProfileServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile registerUser(UserProfile userProfile) {
        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(userProfile.getPassword());
        userProfile.setPassword(encodedPassword);

        return userRepository.save(userProfile);
    }

    @Override
    public Optional<UserProfile> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserProfile updateUser(UserProfile userProfile) {
        // Optionally encode password if it’s changed
        if (userProfile.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(userProfile.getPassword());
            userProfile.setPassword(encodedPassword);
        }
        return userRepository.save(userProfile);
    }
}
