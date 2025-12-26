package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repo;
    private final PasswordEncoder encoder;

    public UserProfileServiceImpl(UserProfileRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public UserProfile createUser(UserProfile u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    public UserProfile getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<UserProfile> getAllUsers() {
        return repo.findAll();
    }
}
