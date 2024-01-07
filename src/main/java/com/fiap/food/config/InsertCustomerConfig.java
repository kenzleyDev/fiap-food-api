package com.fiap.food.config;

import com.fiap.food.adapters.out.InsertCustomerAdapter;
import com.fiap.food.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(insertCustomerAdapter);
    }
}
