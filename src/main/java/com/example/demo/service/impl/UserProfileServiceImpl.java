package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public UserProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserProfile getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
