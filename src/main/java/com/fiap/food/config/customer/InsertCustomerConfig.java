package com.fiap.food.config.customer;

import com.fiap.food.adapters.out.customer.InsertCustomerAdapter;
import com.fiap.food.application.core.usecase.customer.InsertCustomerUseCase;
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
