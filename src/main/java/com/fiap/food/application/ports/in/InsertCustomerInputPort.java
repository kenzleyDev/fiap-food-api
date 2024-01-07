package com.fiap.food.application.ports.in;

import com.fiap.food.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer);
}
