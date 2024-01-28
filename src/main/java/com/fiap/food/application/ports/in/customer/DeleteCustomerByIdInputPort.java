package com.fiap.food.application.ports.in.customer;

import com.fiap.food.errors.exception.NotFoundException;

public interface DeleteCustomerByIdInputPort {

    void delete(Long id) throws NotFoundException;
}
