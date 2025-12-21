package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public UserProfile getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile user) {
        return service.createUser(user);
    }

    @PutMapping("/{id}/status")
    public UserProfile updateUserStatus(@PathVariable Long id, @RequestParam boolean active) {
        service.updateUserStatus(id, active); // update first
        return service.getUserById(id);        // then return updated user
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
