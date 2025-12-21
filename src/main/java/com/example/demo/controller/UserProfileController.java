package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile userProfile) {
        UserProfile created = service.createUser(userProfile);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable Long id) {
        UserProfile user = service.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        List<UserProfile> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserProfile> updateUserStatus(@PathVariable Long id, @RequestParam boolean active) {
        UserProfile updated = service.updateUserStatus(id, active);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/lookup/{userId}")
    public ResponseEntity<UserProfile> findByUserId(@PathVariable String userId) {
        UserProfile user = service.findByUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
