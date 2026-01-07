package com.example.base.application.usecases.customer;

import com.example.base.domain.model.Customer;
import com.example.base.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerRepository repository;

    public Mono<Customer> execute(Customer customer) {
        return repository.save(customer);
    }
}

