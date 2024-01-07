package com.fiap.food.application.core.usecase;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.in.FindCustomerByIdInputPort;
import com.fiap.food.application.ports.in.UpdateCustomerInputPort;
import com.fiap.food.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }
    @Override
    public void update(Customer customer) {
        findCustomerByIdInputPort.find(customer.getId());
        updateCustomerOutputPort.update(customer);
    }
}
