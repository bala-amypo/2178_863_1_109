package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CreditCardRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String cardName;
    private double annualFee;

    // Getters and Setters
    public Long getCardId() { return cardId; }
    public void setCardId(Long cardId) { this.cardId = cardId; }

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }

    public double getAnnualFee() { return annualFee; }
    public void setAnnualFee(double annualFee) { this.annualFee = annualFee; }
}
