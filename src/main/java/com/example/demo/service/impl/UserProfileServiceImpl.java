package com.example.demo.service;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile updateUserProfile(Long id, UserProfile userProfile) {
        UserProfile existing = userProfileRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(userProfile.getName());
        existing.setEmail(userProfile.getEmail());
        existing.setAge(userProfile.getAge());
        return userProfileRepository.save(existing);
    }

    @Override
    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}
