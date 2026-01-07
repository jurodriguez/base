package com.example.prioritization.domain.model;

import java.time.LocalDateTime;

public class Request {

    private final Long id;
    private final RequestType type;
    private final int manualPriority;
    private final LocalDateTime createdAt;
    private final String createdBy;

    public Request(Long id,
                   RequestType type,
                   int manualPriority,
                   LocalDateTime createdAt,
                   String createdBy) {
        this.id = id;
        this.type = type;
        this.manualPriority = manualPriority;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public RequestType getType() {
        return type;
    }

    public int getManualPriority() {
        return manualPriority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
