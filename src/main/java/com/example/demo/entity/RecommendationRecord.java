package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recommendation_records")
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long purchaseIntentId;
    private Long recommendedCardId;
    private double expectedRewardValue;
    private String calculationDetailsJson;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    // Constructors
    public RecommendationRecord() {}

    public RecommendationRecord(UserProfile user, Long purchaseIntentId, Long recommendedCardId,
                                double expectedRewardValue, String calculationDetailsJson) {
        this.user = user;
        this.purchaseIntentId = purchaseIntentId;
        this.recommendedCardId = recommendedCardId;
        this.expectedRewardValue = expectedRewardValue;
        this.calculationDetailsJson = calculationDetailsJson;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }

    public Long getPurchaseIntentId() { return purchaseIntentId; }
    public void setPurchaseIntentId(Long purchaseIntentId) { this.purchaseIntentId = purchaseIntentId; }

    public Long getRecommendedCardId() { return recommendedCardId; }
    public void setRecommendedCardId(Long recommendedCardId) { this.recommendedCardId = recommendedCardId; }

    public double getExpectedRewardValue() { return expectedRewardValue; }
    public void setExpectedRewardValue(double expectedRewardValue) { this.expectedRewardValue = expectedRewardValue; }

    public String getCalculationDetailsJson() { return calculationDetailsJson; }
    public void setCalculationDetailsJson(String calculationDetailsJson) { this.calculationDetailsJson = calculationDetailsJson; }
}
