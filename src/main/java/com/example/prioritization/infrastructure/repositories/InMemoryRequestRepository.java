package com.example.prioritization.infrastructure.repositories;

import com.example.prioritization.domain.model.Request;
import com.example.prioritization.domain.repository.RequestRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRequestRepository implements RequestRepository {

    private final List<Request> storage = new ArrayList<>();

    @Override
    public void save(Request request) {
        storage.add(request);
    }

    @Override
    public List<Request> findAll() {
        return List.copyOf(storage);
    }
}