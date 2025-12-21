package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RewardRuleController {

    private final RewardRuleService rewardService;

    public RewardRuleController(RewardRuleService rewardService) {
        this.rewardService = rewardService;
    }

    @PostMapping
    public RewardRule createRule(@RequestBody RewardRule rule) {
        return rewardService.createRule(rule);
    }

    @GetMapping
    public List<RewardRule> getAllRules() {
        return rewardService.getAllRules();
    }
}
