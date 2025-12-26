package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseIntentRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String category;
    private Double amount;
    private String merchant;

    // getters & setters
}
