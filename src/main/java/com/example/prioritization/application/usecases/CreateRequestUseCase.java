package com.example.prioritization.application.usecases;

import com.example.prioritization.application.dto.RequestCreateDto;
import com.example.prioritization.application.mapper.RequestMapper;
import com.example.prioritization.domain.model.Request;
import com.example.prioritization.domain.repository.RequestRepository;

import java.util.concurrent.atomic.AtomicLong;

public class CreateRequestUseCase {

    private final RequestRepository repository;
    private final AtomicLong idGenerator = new AtomicLong(1);

    public CreateRequestUseCase(RequestRepository repository) {
        this.repository = repository;
    }

    public void execute(RequestCreateDto dto) {
        Request request = RequestMapper.toDomain(
                dto,
                idGenerator.getAndIncrement()
        );
        repository.save(request);
    }
}
