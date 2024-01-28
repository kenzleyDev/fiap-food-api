package com.fiap.food.application.ports.in.customer;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.errors.exception.NotFoundException;

public interface FindCustomerByIdInputPort {

    Customer find(Long id) throws NotFoundException;
}
