package com.fiap.food.config.customer;

import com.fiap.food.adapters.out.customer.UpdateCustomerAdapter;
import com.fiap.food.application.core.usecase.customer.FindCustomerByIdUseCase;
import com.fiap.food.application.core.usecase.customer.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, updateCustomerAdapter);
    }
}
