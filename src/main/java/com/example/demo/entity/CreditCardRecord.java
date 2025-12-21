package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardName;
    private double annualFee;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }

    public double getAnnualFee() { return annualFee; }
    public void setAnnualFee(double annualFee) { this.annualFee = annualFee; }
}

