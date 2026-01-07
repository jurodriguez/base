package com.example.base.application.usecases.customer;

import com.example.base.domain.exceptions.BusinessException;
import com.example.base.domain.model.Customer;
import com.example.base.domain.model.CustomerError;
import com.example.base.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCustomerUseCase {

    private final CustomerRepository repository;

    public Mono<Customer> execute(Long id, Customer updates) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new BusinessException(CustomerError.CUSTOMER_NOT_FOUND)))
                .flatMap(existing -> {

                    if (updates.getName() != null) existing.setName(updates.getName());
                    if (updates.getAge() != null) existing.setAge(updates.getAge());
                    if (updates.getIdentification() != null) existing.setIdentification(updates.getIdentification());
                    if (updates.getPassword() != null) existing.setPassword(updates.getPassword());
                    if (updates.getStatus() != null) existing.setStatus(updates.getStatus());
                    if (updates.getGender() != null) existing.setGender(updates.getGender());
                    if (updates.getAddress() != null) existing.setAddress(updates.getAddress());
                    if (updates.getPhone() != null) existing.setPhone(updates.getPhone());

                    return repository.update(existing)
                            .then(repository.findById(id));
                });
    }

}

