package com.example.base.infrastructure.config;

import com.example.base.application.usecases.customer.*;
import com.example.base.domain.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerRepository repo) {
        return new CreateCustomerUseCase(repo);
    }

    @Bean
    public GetCustomerUseCase getCustomerUseCase(CustomerRepository repo) {
        return new GetCustomerUseCase(repo);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(CustomerRepository repo) {
        return new UpdateCustomerUseCase(repo);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository repo) {
        return new DeleteCustomerUseCase(repo);
    }

    @Bean
    public ListCustomersUseCase listCustomersUseCase(CustomerRepository repo) {
        return new ListCustomersUseCase(repo);
    }
}
