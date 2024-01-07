package com.fiap.food.adapters.out;

import com.fiap.food.adapters.out.repository.CustomerRepository;
import com.fiap.food.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
