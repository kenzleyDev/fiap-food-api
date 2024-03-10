package com.fiap.food.api.customer.service;

import com.fiap.food.api.customer.mapper.CustomerEntityMapper;
import com.fiap.food.api.customer.dto.Customer;
import com.fiap.food.core.exception.NotFoundException;
import com.fiap.food.core.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

    @Override
    public void update(Customer customer) throws NotFoundException {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

    @Override
    public Optional<Customer> findById(Long id) throws NotFoundException {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) throws NotFoundException {
        var customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        customerRepository.deleteById(id);
    }
}
