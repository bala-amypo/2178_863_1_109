package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.RecommendationEngineService;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final CreditCardRecordRepository creditCardRecordRepository;

    public RecommendationEngineServiceImpl(
            CreditCardRecordRepository creditCardRecordRepository) {
        this.creditCardRecordRepository = creditCardRecordRepository;
    }

    @Override
    public List<CreditCardRecord> recommendCards(Long userId) {
        // Simple logic for now
        return creditCardRecordRepository.findAll();
    }
}
