package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_card_records")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private double annualFee;

    @Column(nullable = false)
    private double rewardRate;

    // Constructors
    public CreditCardRecord() {}

    public CreditCardRecord(String cardName, double annualFee, double rewardRate) {
        this.cardName = cardName;
        this.annualFee = annualFee;
        this.rewardRate = rewardRate;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }

    public double getAnnualFee() { return annualFee; }
    public void setAnnualFee(double annualFee) { this.annualFee = annualFee; }

    public double getRewardRate() { return rewardRate; }
    public void setRewardRate(double rewardRate) { this.rewardRate = rewardRate; }
}
