package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfile getByEmail(String email) {
        return userProfileRepository.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userProfileRepository.deleteById(id);
    }
}
