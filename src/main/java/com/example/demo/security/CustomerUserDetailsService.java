package com.example.demo.security;

import com.example.demo.repository.UserProfileRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserProfileRepository repo;

    public CustomUserDetailsService(UserProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return repo.findByUserId(username)
            .map(u -> User.withUsername(u.getUserId())
                .password(u.getPassword())
                .roles(u.getRole())
                .build())
            .orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
    }
}
