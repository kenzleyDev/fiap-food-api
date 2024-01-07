package com.fiap.food.config;

import com.fiap.food.adapters.out.UpdateCustomerAdapter;
import com.fiap.food.application.core.usecase.FindCustomerByIdUseCase;
import com.fiap.food.application.core.usecase.UpdateCustomerUseCase;
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
