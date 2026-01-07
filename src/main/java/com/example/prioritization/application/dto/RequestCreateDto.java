package com.example.prioritization.application.dto;

import com.example.prioritization.domain.model.RequestType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestCreateDto {

    @NotNull(message = "type is required")
    private RequestType type;

    @Min(value = 1, message = "manualPriority must be between 1 and 5")
    @Max(value = 5, message = "manualPriority must be between 1 and 5")
    private int manualPriority;

    @NotBlank(message = "createdBy is required")
    private String createdBy;

    public RequestType getType() {
        return type;
    }

    public int getManualPriority() {
        return manualPriority;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}

