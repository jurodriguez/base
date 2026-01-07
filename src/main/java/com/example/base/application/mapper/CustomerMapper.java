package com.example.base.application.mapper;

import com.example.base.application.dto.CustomerRequest;
import com.example.base.application.dto.CustomerResponse;
import com.example.base.application.dto.CustomerUpdateRequest;
import com.example.base.domain.model.Customer;
import com.example.base.infrastructure.repositories.data.CustomerData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toCustomerDomain(CustomerRequest request);

    @Mapping(target = "id", ignore = true)
    Customer toCustomerDomain(CustomerUpdateRequest request);

    @Mapping(target = "id", source = "id")
    CustomerData toData(Customer customer);

    @Mapping(target = "password", source = "password")
    @Mapping(target = "status", source = "status")
    Customer toDomain(CustomerData data);

    @Mapping(target = "id", source = "id")
    CustomerResponse toResponse(Customer customer);
}

