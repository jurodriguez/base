package com.example.base.infrastructure.repositories;

import com.example.base.infrastructure.repositories.data.CustomerData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerDataRepository extends ReactiveCrudRepository<CustomerData, Long> {
}
