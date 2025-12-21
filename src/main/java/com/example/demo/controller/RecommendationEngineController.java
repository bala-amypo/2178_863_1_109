package com.example.demo.controller;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEngineController {

    private final RecommendationEngineService recommendationService;

    public RecommendationEngineController(RecommendationEngineService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/generate")
    public RecommendationRecord generateRecommendation(@RequestParam Long userId,
                                                       @RequestParam Long purchaseIntentId) {
        return recommendationService.generateRecommendation(userId, purchaseIntentId);
    }

    @GetMapping
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }
}
