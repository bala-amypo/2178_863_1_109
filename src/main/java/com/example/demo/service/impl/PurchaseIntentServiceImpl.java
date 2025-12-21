package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.repository.PurchaseIntentRepository;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRepository intentRepository;

    public PurchaseIntentServiceImpl(PurchaseIntentRepository intentRepository) {
        this.intentRepository = intentRepository;
    }

    @Override
    public PurchaseIntentRecord createIntent(PurchaseIntentRecord intent) {
        return intentRepository.save(intent);
    }

    @Override
    public List<PurchaseIntentRecord> getAllIntents() {
        return intentRepository.findAll();
    }
}
