package com.fiap.food.api.customer.mapper;

import com.fiap.food.api.customer.dto.CustomerRequest;
import com.fiap.food.api.customer.dto.CustomerResponse;
import com.fiap.food.api.customer.dto.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
    CustomerResponse toCustomerResponse(Customer customer);
}
