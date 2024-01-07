package com.fiap.food.adapters.out.repository.mapper;

import com.fiap.food.adapters.out.repository.entity.CustomerEntity;
import com.fiap.food.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
