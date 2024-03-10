package com.fiap.food.api.customer.mapper;

import com.fiap.food.core.model.CustomerEntity;
import com.fiap.food.api.customer.dto.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    @Mapping(target = "orders", ignore = true)
    CustomerEntity toCustomerEntity(Customer customer);

    @Mapping(target = "orders", ignore = true)
    Customer toCustomer(CustomerEntity customerEntity);
}