package com.fiap.food.application.core.usecase.customer;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.in.customer.FindCustomerByCpfInputPort;
import com.fiap.food.application.ports.out.customer.FindCustomerByCpfOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindCustomerByCpfUseCase implements FindCustomerByCpfInputPort {

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    public FindCustomerByCpfUseCase(FindCustomerByCpfOutputPort findCustomerByCpfOutputPort) {
        this.findCustomerByCpfOutputPort = findCustomerByCpfOutputPort;
    }

    @Override
    public Customer find(String cpf) throws NotFoundException {
        return findCustomerByCpfOutputPort.find(cpf)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
