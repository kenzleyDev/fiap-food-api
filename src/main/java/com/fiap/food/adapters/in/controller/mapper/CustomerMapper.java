package com.fiap.food.adapters.in.controller.mapper;

import com.fiap.food.adapters.in.controller.request.CustomerRequest;
import com.fiap.food.adapters.in.controller.response.CustomerResponse;
import com.fiap.food.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
    CustomerResponse toCustomerResponse(Customer customer);
}
