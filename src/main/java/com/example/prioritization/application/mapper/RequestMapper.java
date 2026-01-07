package com.example.prioritization.application.mapper;

import com.example.prioritization.application.dto.RequestCreateDto;
import com.example.prioritization.application.dto.RequestResponseDto;
import com.example.prioritization.domain.model.Request;

import java.time.LocalDateTime;

public final class RequestMapper {

    private RequestMapper() {
    }

    public static Request toDomain(RequestCreateDto dto, Long id) {
        return new Request(
                id,
                dto.getType(),
                dto.getManualPriority(),
                LocalDateTime.now(),
                dto.getCreatedBy()
        );
    }

    public static RequestResponseDto toResponse(Request request, int calculatedPriority) {
        return new RequestResponseDto(
                request.getId(),
                request.getType().name(),
                request.getManualPriority(),
                request.getCreatedAt(),
                request.getCreatedBy(),
                calculatedPriority
        );
    }
}
