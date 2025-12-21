package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import java.util.List;

public interface UserProfileService {

    UserProfile getUserById(Long id);

    List<UserProfile> getAllUsers();

    void updateUserStatus(Long id, boolean active);

    UserProfile createUser(UserProfile user);

    void deleteUser(Long id);
}
