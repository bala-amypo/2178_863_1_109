package com.example.demo.service.impl;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final RecommendationRepository recommendationRepository;

    public RecommendationEngineServiceImpl(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<RecommendationRecord> generateRecommendations(Long userId) {
        // Simple example: fetch all recommendations for the user
        return recommendationRepository.findByUserId(userId);
    }
}
