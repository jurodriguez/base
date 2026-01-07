package com.example.prioritization.domain.rules;

import com.example.prioritization.domain.model.Request;
import com.example.prioritization.domain.model.RequestType;

public class IncidentPriorityRule implements PriorityRule {

    @Override
    public int apply(Request request) {
        return request.getType() == RequestType.INCIDENT ? 50 : 0;
    }
}