package com.example.demo.service;

import com.example.demo.entity.CreditCardRecord;
import java.util.List;

public interface RecommendationEngineService {

    List<CreditCardRecord> recommendCards(Long userId);

}
