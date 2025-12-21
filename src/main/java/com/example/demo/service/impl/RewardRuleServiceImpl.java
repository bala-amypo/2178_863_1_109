package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository rewardRepository;

    public RewardRuleServiceImpl(RewardRuleRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @Override
    public RewardRule createRule(RewardRule rule) {
        return rewardRepository.save(rule);
    }

    @Override
    public List<RewardRule> getAllRules() {
        return rewardRepository.findAll();
    }
}
