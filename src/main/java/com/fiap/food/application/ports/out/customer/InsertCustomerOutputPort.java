package com.fiap.food.application.ports.out.customer;

import com.fiap.food.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
