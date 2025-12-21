package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intents")
public class PurchaseIntentController {

    private final PurchaseIntentService purchaseIntentService;

    public PurchaseIntentController(PurchaseIntentService purchaseIntentService) {
        this.purchaseIntentService = purchaseIntentService;
    }

    // Create a new purchase intent
    @PostMapping("/")
    public ResponseEntity<PurchaseIntentRecord> createIntent(@RequestBody PurchaseIntentRecord intent) {
        PurchaseIntentRecord createdIntent = purchaseIntentService.createIntent(intent);
        return new ResponseEntity<>(createdIntent, HttpStatus.CREATED);
    }

    // Get all intents for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PurchaseIntentRecord>> getIntentsByUser(@PathVariable Long userId) {
        List<PurchaseIntentRecord> intents = purchaseIntentService.getIntentsByUser(userId);
        return new ResponseEntity<>(intents, HttpStatus.OK);
    }

    // Get a specific intent by ID
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseIntentRecord> getIntentById(@PathVariable Long id) {
        PurchaseIntentRecord intent = purchaseIntentService.getIntentById(id);
        return new ResponseEntity<>(intent, HttpStatus.OK);
    }

    // Get all intents (for admin/testing)
    @GetMapping("/")
    public ResponseEntity<List<PurchaseIntentRecord>> getAllIntents() {
        List<PurchaseIntentRecord> intents = purchaseIntentService.getAllIntents();
        return new ResponseEntity<>(intents, HttpStatus.OK);
    }
}
