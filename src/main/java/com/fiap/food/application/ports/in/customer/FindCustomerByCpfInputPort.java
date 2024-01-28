package com.fiap.food.application.ports.in.customer;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.errors.exception.NotFoundException;

public interface FindCustomerByCpfInputPort {

    Customer find(String cpf) throws NotFoundException;
}
