package com.example.demo.service;

import com.example.demo.entity.RecommendationRecord;
import java.util.List;

public interface RecommendationService {

    RecommendationRecord generate(Long intentId);

    RecommendationRecord getById(Long id);

    List<RecommendationRecord> getByUser(Long userId);

    List<RecommendationRecord> getAll();
}
