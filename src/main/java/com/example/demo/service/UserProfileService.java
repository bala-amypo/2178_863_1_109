package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface UserProfileService {

    UserProfile getByEmail(String email);

}
