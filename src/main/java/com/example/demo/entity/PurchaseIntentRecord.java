package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseIntentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intentId;

    private Long userId;
    private double amount;

    // Getters and Setters
    public Long getIntentId() { return intentId; }
    public void setIntentId(Long intentId) { this.intentId = intentId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
