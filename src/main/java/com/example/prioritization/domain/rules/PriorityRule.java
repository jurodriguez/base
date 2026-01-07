package com.example.prioritization.rules;

import com.example.prioritization.domain.model.Request;

public interface PriorityRule {
    int apply(Request request);
}
