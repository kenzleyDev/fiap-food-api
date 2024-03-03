package com.fiap.food.api.customer.service;

import com.fiap.food.api.customer.dto.Customer;
import com.fiap.food.core.exception.NotFoundException;

import java.util.Optional;

public interface CustomerService {
    void insert(Customer customer);
    void update(Customer customer) throws NotFoundException;
    Optional<Customer> findById(Long id) throws NotFoundException;
    Optional<Customer> findByCpf(String cpf) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
