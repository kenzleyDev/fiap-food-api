package com.fiap.food.application.ports.in;

import com.fiap.food.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(Long id);
}
