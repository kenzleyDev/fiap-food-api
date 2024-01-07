package com.fiap.food.adapters.out.customer;

import com.fiap.food.adapters.out.repository.CustomerRepository;
import com.fiap.food.adapters.out.repository.mapper.CustomerEntityMapper;
import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.out.customer.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public Optional<Customer> find(Long id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
