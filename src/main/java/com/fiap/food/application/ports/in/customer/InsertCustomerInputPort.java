package com.fiap.food.application.ports.in.customer;

import com.fiap.food.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer);
}
