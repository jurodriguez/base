package com.example.prioritization.application.dto;

import java.time.LocalDateTime;

public class RequestResponseDto {

    private Long id;
    private String type;
    private int manualPriority;
    private LocalDateTime createdAt;
    private String createdBy;
    private int calculatedPriority;

    public RequestResponseDto() {
    }

    public RequestResponseDto(Long id,
                              String type,
                              int manualPriority,
                              LocalDateTime createdAt,
                              String createdBy,
                              int calculatedPriority) {
        this.id = id;
        this.type = type;
        this.manualPriority = manualPriority;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.calculatedPriority = calculatedPriority;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
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

    public int getCalculatedPriority() {
        return calculatedPriority;
    }
}
