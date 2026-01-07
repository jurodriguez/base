package com.example.prioritization.application.usecases;

import com.example.prioritization.application.dto.RequestResponseDto;
import com.example.prioritization.application.mapper.RequestMapper;
import com.example.prioritization.domain.repository.RequestRepository;
import com.example.prioritization.domain.rules.AgingPriorityRule;
import com.example.prioritization.domain.rules.IncidentPriorityRule;
import com.example.prioritization.domain.rules.ManualPriorityRule;
import com.example.prioritization.domain.service.PriorityCalculator;

import java.util.Comparator;
import java.util.List;

public class GetPrioritizedRequestsUseCase {

    private final RequestRepository repository;
    private final PriorityCalculator calculator;

    public GetPrioritizedRequestsUseCase(RequestRepository repository) {
        this.repository = repository;
        this.calculator = new PriorityCalculator(List.of(
                new IncidentPriorityRule(),
                new AgingPriorityRule(),
                new ManualPriorityRule()
        ));
    }

    public List<RequestResponseDto> execute() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingInt(calculator::calculate).reversed())
                .map(request ->
                        RequestMapper.toResponse(
                                request,
                                calculator.calculate(request)
                        )
                )
                .toList();
    }
}
