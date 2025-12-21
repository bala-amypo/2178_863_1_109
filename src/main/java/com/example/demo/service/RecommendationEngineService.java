package com.example.demo.service;

import com.example.demo.entity.CreditCard;
import java.util.List;

public interface RecommendationEngineService {

    List<CreditCard> recommendCards(Long userId);

}
