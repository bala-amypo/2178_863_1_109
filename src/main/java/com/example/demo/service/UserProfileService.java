package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserProfile;

public interface UserProfileService {

    UserProfile save(UserProfile userProfile);

    List<UserProfile> getAll();

    UserProfile getById(Long id);

    UserProfile getByEmail(String email);

    void delete(Long id);
}
