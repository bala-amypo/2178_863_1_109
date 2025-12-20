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

    @PostMapping
    public UserProfile create(@RequestBody UserProfile user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserProfile getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserProfile> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}/status")
    public UserProfile updateStatus(@PathVariable Long id,
                                    @RequestParam boolean active) {
        return service.updateUserStatus(id, active);
    }

    @GetMapping("/lookup/{userId}")
    public UserProfile getByUserId(@PathVariable String userId) {
        return service.findByUserId(userId);
    }
}
