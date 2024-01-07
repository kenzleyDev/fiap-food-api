package com.fiap.food.application.core.usecase.customer;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.in.customer.FindCustomerByIdInputPort;
import com.fiap.food.application.ports.in.customer.UpdateCustomerInputPort;
import com.fiap.food.application.ports.out.customer.UpdateCustomerOutputPort;

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
