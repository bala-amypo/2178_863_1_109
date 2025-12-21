package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private double annualFee;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getAnnualFee() { return annualFee; }
    public void setAnnualFee(double annualFee) { this.annualFee = annualFee; }
}
