package com.example.prioritization.infrastructure.config;

import com.example.prioritization.application.usecases.CreateRequestUseCase;
import com.example.prioritization.application.usecases.GetPrioritizedRequestsUseCase;
import com.example.prioritization.domain.repository.RequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CreateRequestUseCase createRequestUseCase(
            RequestRepository requestRepository
    ) {
        return new CreateRequestUseCase(requestRepository);
    }

    @Bean
    public GetPrioritizedRequestsUseCase getPrioritizedRequestsUseCase(
            RequestRepository requestRepository
    ) {
        return new GetPrioritizedRequestsUseCase(requestRepository);
    }
}
