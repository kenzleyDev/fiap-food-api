package com.fiap.food.adapters.out.repository.mapper;

import com.fiap.food.adapters.out.repository.entity.CustomerEntity;
import com.fiap.food.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    @Mapping(target = "orders", ignore = true)
    CustomerEntity toCustomerEntity(Customer customer);

    @Mapping(target = "orders", ignore = true)
    Customer toCustomer(CustomerEntity customerEntity);
}