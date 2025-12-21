package com.example.demo.service;

import com.example.demo.entity.RecommendationRecord;

import java.util.List;

public interface RecommendationEngineService {
    RecommendationRecord generateRecommendation(Long userId, Long purchaseIntentId);
    List<RecommendationRecord> getAllRecommendations();
}
