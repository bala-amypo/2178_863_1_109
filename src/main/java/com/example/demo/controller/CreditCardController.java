package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<CreditCardRecord> createCard(@RequestBody CreditCardRecord card) {
        return ResponseEntity.ok(creditCardService.createCard(card));
    }

    @GetMapping
    public ResponseEntity<List<CreditCardRecord>> getAllCards() {
        return ResponseEntity.ok(creditCardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardRecord> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(creditCardService.getCardById(id));
    }
}
