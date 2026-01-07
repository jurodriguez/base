package com.example.prioritization.domain.service;

import com.example.prioritization.domain.model.Request;
import com.example.prioritization.domain.rules.PriorityRule;

import java.util.List;

public class PriorityCalculator {

    private final List<PriorityRule> rules;

    public PriorityCalculator(List<PriorityRule> rules) {
        this.rules = rules;
    }

    public int calculate(Request request) {
        return rules.stream()
                .mapToInt(rule -> rule.apply(request))
                .sum();
    }
}
