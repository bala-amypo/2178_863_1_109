package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long purchaseIntentId;
    private Long recommendedCardId;
    private double expectedRewardValue;

    @Column(length = 1000)
    private String calculationDetailsJson;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPurchaseIntentId() { return purchaseIntentId; }
    public void setPurchaseIntentId(Long purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
    }

    public Long getRecommendedCardId() { return recommendedCardId; }
    public void setRecommendedCardId(Long recommendedCardId) {
        this.recommendedCardId = recommendedCardId;
    }

    public double getExpectedRewardValue() { return expectedRewardValue; }
    public void setExpectedRewardValue(double expectedRewardValue) {
        this.expectedRewardValue = expectedRewardValue;
    }

    public String getCalculationDetailsJson() { return calculationDetailsJson; }
    public void setCalculationDetailsJson(String calculationDetailsJson) {
        this.calculationDetailsJson = calculationDetailsJson;
    }
}
