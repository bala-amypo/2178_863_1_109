package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface UserService {

    UserProfile register(UserProfile user);

    UserProfile findByUserId(String userId);
}
