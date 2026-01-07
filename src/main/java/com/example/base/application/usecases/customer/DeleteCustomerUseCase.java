package com.example.base.application.usecases.customer;

import com.example.base.domain.exceptions.BusinessException;
import com.example.base.domain.model.CustomerError;
import com.example.base.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerRepository repository;

    public Mono<Void> execute(Long id) {

        return repository.findById(id)
                .switchIfEmpty(Mono.error(new BusinessException(CustomerError.CUSTOMER_NOT_FOUND)))
                .flatMap(customer -> repository.deleteById(id)
                );
    }
}