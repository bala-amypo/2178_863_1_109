package com.example.demo.service;

import com.example.demo.entity.RecommendationRecord;
import java.util.List;

public interface RecommendationEngineService {
    // Add this method if it's missing
    List<RecommendationRecord> generateRecommendations(Long userId);
}
