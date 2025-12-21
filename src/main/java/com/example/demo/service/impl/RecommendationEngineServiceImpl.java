package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final RecommendationRecordRepository recommendationRepository;
    private final UserProfileRepository userRepository;
    private final CreditCardRepository cardRepository;
    private final PurchaseIntentRepository intentRepository;
    private final RewardRuleRepository rewardRepository;

    public RecommendationEngineServiceImpl(RecommendationRecordRepository recommendationRepository,
                                           UserProfileRepository userRepository,
                                           CreditCardRepository cardRepository,
                                           PurchaseIntentRepository intentRepository,
                                           RewardRuleRepository rewardRepository) {
        this.recommendationRepository = recommendationRepository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.intentRepository = intentRepository;
        this.rewardRepository = rewardRepository;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long userId, Long purchaseIntentId) {
        UserProfile user = userRepository.findById(userId).orElseThrow();
        PurchaseIntentRecord intent = intentRepository.findById(purchaseIntentId).orElseThrow();
        List<CreditCardRecord> cards = cardRepository.findAll();
        List<RewardRule> rules = rewardRepository.findAll();

        // Create recommendation record
        RecommendationRecord record = new RecommendationRecord();
        record.setUserId(user.getId());
        record.setPurchaseIntentId(intent.getId());

        // Example simple logic: assign first card and calculate reward
        CreditCardRecord card = cards.get(0);
        RewardRule rule = rules.get(0);

        record.setRecommendedCardId(card.getId());
        record.setExpectedRewardValue(intent.getAmount() * rule.getMultiplier());
        record.setCalculationDetailsJson("{\"cardId\":" + card.getId() + ",\"multiplier\":" + rule.getMultiplier() + "}");

        return recommendationRepository.save(record);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}
