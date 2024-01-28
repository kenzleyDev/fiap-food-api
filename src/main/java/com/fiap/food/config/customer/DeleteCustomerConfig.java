package com.fiap.food.config.customer;

import com.fiap.food.adapters.out.customer.DeleteCustomerByIdAdapter;
import com.fiap.food.application.core.usecase.customer.DeleteCustomerByIdUseCase;
import com.fiap.food.application.core.usecase.customer.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
