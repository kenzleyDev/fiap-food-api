package com.fiap.food.adapters.out.customer;

import com.fiap.food.adapters.out.repository.CustomerRepository;
import com.fiap.food.adapters.out.repository.mapper.CustomerEntityMapper;
import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.out.customer.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}