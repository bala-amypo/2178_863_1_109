package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserProfileService;
import com.example.demo.repository.UserProfileRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserProfileService userProfileService;
    private final UserProfileRepository userProfileRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserProfileService userProfileService,
                          UserProfileRepository userProfileRepository,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userProfileService = userProfileService;
        this.userProfileRepository = userProfileRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody RegisterRequest request) {
        UserProfile profile = new UserProfile();
        profile.setUserId(request.getUserId());
        profile.setFullName(request.getFullName());
        profile.setEmail(request.getEmail());
        profile.setPassword(request.getPassword());
        profile.setRole(request.getRole());
        profile.setActive(true);

        UserProfile saved = userProfileService.createUser(profile);
        String token = jwtUtil.generateToken(saved.getEmail());

        return new JwtResponse(token, saved.getEmail(), saved.getUserId(), saved.getRole());
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserProfile user = userProfileRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtil.generateToken(user.getEmail());

        return new JwtResponse(token, user.getEmail(), user.getUserId(), user.getRole());
    }
}
