package com.fiap.food.application.ports.in;

import com.fiap.food.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer);
}
