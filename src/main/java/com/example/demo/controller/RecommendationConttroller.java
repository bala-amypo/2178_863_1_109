package com.example.demo.controller;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.repository.RecommendationRecordRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationRecordRepository repo;

    public RecommendationController(
            RecommendationRecordRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/generate/{intentId}")
    public RecommendationRecord generate(
            @PathVariable Long intentId) {
        RecommendationRecord r = new RecommendationRecord();
        r.setPurchaseIntentId(intentId);
        r.setExpectedRewardValue(100.0);
        return repo.save(r);
    }

    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> byUser(
            @PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @GetMapping("/{id}")
    public RecommendationRecord byId(
            @PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping
    public List<RecommendationRecord> all() {
        return repo.findAll();
    }
}
