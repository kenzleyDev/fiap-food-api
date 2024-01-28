package com.fiap.food.application.ports.out.customer;

import com.fiap.food.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByCpfOutputPort {
    Optional<Customer> find(String cpf);
}
