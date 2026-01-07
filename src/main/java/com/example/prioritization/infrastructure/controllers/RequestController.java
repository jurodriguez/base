package com.example.prioritization.infrastructure.controllers;

import com.example.prioritization.application.dto.RequestCreateDto;
import com.example.prioritization.application.dto.RequestResponseDto;
import com.example.prioritization.application.usecases.CreateRequestUseCase;
import com.example.prioritization.application.usecases.GetPrioritizedRequestsUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private final CreateRequestUseCase createUseCase;
    private final GetPrioritizedRequestsUseCase getUseCase;

    public RequestController(CreateRequestUseCase createUseCase,
                             GetPrioritizedRequestsUseCase getUseCase) {
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody RequestCreateDto dto) {
        createUseCase.execute(dto);
    }

    @GetMapping("/prioritized")
    public List<RequestResponseDto> getPrioritized() {
        return getUseCase.execute();
    }
}

