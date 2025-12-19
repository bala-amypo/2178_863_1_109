package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.JwtUtil;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.entity.UserProfile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserProfileRepository repo;

    public AuthController(JwtUtil jwtUtil,
                          UserProfileRepository repo) {
        this.jwtUtil = jwtUtil;
        this.repo = repo;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest req) {
        return new JwtResponse(jwtUtil.generateToken(req.getUserId()));
    }

    @PostMapping("/register")
    public UserProfile register(
            @RequestBody RegisterRequest req) {
        UserProfile u = new UserProfile();
        u.setUserId(req.getUserId());
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        return repo.save(u);
    }
}
