package com.example.base.application.usecases.customer;

import com.example.base.domain.exceptions.BusinessException;
import com.example.base.domain.model.Customer;
import com.example.base.domain.model.CustomerError;
import com.example.base.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetCustomerUseCase {

    private final CustomerRepository repository;

    public Mono<Customer> execute(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new BusinessException(CustomerError.CUSTOMER_NOT_FOUND)));
    }

    public Flux<Customer> findAll() {
        return repository.findAll();
    }
}
