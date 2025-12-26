package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RecommendationRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private Double expectedRewardValue;

    @Column(length = 2000)
    private String calculationDetailsJson;

    // getters & setters
}
