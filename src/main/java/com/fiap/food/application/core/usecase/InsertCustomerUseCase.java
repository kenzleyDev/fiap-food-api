package com.fiap.food.application.core.usecase;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.ports.in.InsertCustomerInputPort;
import com.fiap.food.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    public InsertCustomerUseCase(
            InsertCustomerOutputPort insertCustomerOutputPort) {
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer) {
        insertCustomerOutputPort.insert(customer);
    }
}
