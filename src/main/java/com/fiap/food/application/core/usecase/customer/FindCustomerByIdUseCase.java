package com.fiap.food.application.core.usecase.customer;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.in.customer.FindCustomerByIdInputPort;
import com.fiap.food.application.ports.out.customer.FindCustomerByIdOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(Long id) throws NotFoundException {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));

    }
}
