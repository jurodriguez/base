package com.example.prioritization.domain.rules;

import com.example.prioritization.domain.model.Request;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AgingPriorityRule implements PriorityRule {

    @Override
    public int apply(Request request) {
        long hours = ChronoUnit.HOURS.between(
                request.getCreatedAt(),
                LocalDateTime.now()
        );
        return (int) Math.min(hours, 24);
    }
}

