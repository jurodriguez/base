package com.example.prioritization.domain.rules;

import com.example.prioritization.domain.model.Request;

public class ManualPriorityRule implements PriorityRule {

    @Override
    public int apply(Request request) {
        return request.getManualPriority() * 10;
    }
}
