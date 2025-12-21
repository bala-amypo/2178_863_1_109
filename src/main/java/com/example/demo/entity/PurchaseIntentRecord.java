package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_intent_records")
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @Column(nullable = false)
    private double purchaseAmount;

    @Column(nullable = false)
    private String category;

    // Constructors
    public PurchaseIntentRecord() {}

    public PurchaseIntentRecord(UserProfile user, double purchaseAmount, String category) {
        this.user = user;
        this.purchaseAmount = purchaseAmount;
        this.category = category;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }

    public double getPurchaseAmount() { return purchaseAmount; }
    public void setPurchaseAmount(double purchaseAmount) { this.purchaseAmount = purchaseAmount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
