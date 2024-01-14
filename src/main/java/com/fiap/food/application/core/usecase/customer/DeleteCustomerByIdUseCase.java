package com.fiap.food.application.core.usecase.customer;

import com.fiap.food.application.ports.in.customer.DeleteCustomerByIdInputPort;
import com.fiap.food.application.ports.in.customer.FindCustomerByIdInputPort;
import com.fiap.food.application.ports.out.customer.DeleteCustomerByIdOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }

}
