package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import java.util.List;

public interface UserProfileService {

    UserProfile createUserProfile(UserProfile userProfile);

    UserProfile getUserProfileById(Long id);

    List<UserProfile> getAllUserProfiles();

    UserProfile updateUserProfile(Long id, UserProfile userProfile);

    void deleteUserProfile(Long id);
}
