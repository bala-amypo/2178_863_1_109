package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reward_rules")
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private double rewardRate;

    // Constructors
    public RewardRule() {}

    public RewardRule(String category, double rewardRate) {
        this.category = category;
        this.rewardRate = rewardRate;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getRewardRate() { return rewardRate; }
    public void setRewardRate(double rewardRate) { this.rewardRate = rewardRate; }
}
