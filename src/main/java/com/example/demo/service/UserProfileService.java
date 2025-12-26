package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import java.util.List;

public interface UserProfileService {

    UserProfile save(UserProfile userProfile);

    List<UserProfile> getAll();

    UserProfile getById(Long id);

    UserProfile getByEmail(String email);

    void delete(Long id);
}


