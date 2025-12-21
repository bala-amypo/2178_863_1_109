package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RecommendationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    private Long userId;
    private Long recommendedCardId;
    private Long purchaseIntentId;
    private double expectedRewardValue;
    private String calculationDetailsJson;

    // Getters and Setters
    public Long getRecordId() { return recordId; }
    public void setRecordId(Long recordId) { this.recordId = recordId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRecommendedCardId() { return recommendedCardId; }
    public void setRecommendedCardId(Long recommendedCardId) { this.recommendedCardId = recommendedCardId; }

    public Long getPurchaseIntentId() { return purchaseIntentId; }
    public void setPurchaseIntentId(Long purchaseIntentId) { this.purchaseIntentId = purchaseIntentId; }

    public double getExpectedRewardValue() { return expectedRewardValue; }
    public void setExpectedRewardValue(double expectedRewardValue) { this.expectedRewardValue = expectedRewardValue; }

    public String getCalculationDetailsJson() { return calculationDetailsJson; }
    public void setCalculationDetailsJson(String calculationDetailsJson) { this.calculationDetailsJson = calculationDetailsJson; }
}
