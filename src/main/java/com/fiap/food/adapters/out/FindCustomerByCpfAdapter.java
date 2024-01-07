package com.fiap.food.adapters.out;

import com.fiap.food.adapters.out.repository.CustomerRepository;
import com.fiap.food.adapters.out.repository.mapper.CustomerEntityMapper;
import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.out.FindCustomerByCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByCpfAdapter implements FindCustomerByCpfOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public Optional<Customer> find(String cpf) {
        var customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
