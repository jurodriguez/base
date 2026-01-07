package com.example.prioritization.domain.repository;

import com.example.prioritization.domain.model.Request;

import java.util.List;

public interface RequestRepository {
    void save(Request request);
    List<Request> findAll();
}
