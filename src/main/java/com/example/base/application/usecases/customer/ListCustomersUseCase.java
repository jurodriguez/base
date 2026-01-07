package com.example.base.application.usecases.customer;

import com.example.base.domain.model.Customer;
import com.example.base.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListCustomersUseCase {

    private final CustomerRepository repository;

    public Flux<Customer> execute() {
        return repository.findAll();
    }
}
